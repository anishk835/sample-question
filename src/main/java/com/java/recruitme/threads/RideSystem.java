/*
# 🚗 Ride Sharing System – Concurrency Design Problem

## 📌 Problem Statement

Design a multi-threaded ride-sharing system where passengers request rides and drivers are assigned dynamically.

The system should simulate the interaction between **drivers** and **passengers** using proper concurrency constructs in Java.

---

## 🎯 Requirements

### Inputs

The application receives two command-line arguments:

1. **Number of Drivers (D)**

   * Range: `1 ≤ D ≤ 10`

2. **Number of Passengers (P)**

   * Range: `1 ≤ P ≤ 20`

---

## 🏗️ System Design

### Class: `RideSystem`

The system should contain the following attributes:

```java
private Queue<Integer> availableDrivers;
private BlockingQueue<Integer> waitingPassengers;
private List<String> logs;
private int numberOfDrivers;
```

---

## ⚙️ Functional Requirements

### 1. `requestRide(int passengerId)`

* **Type:** `synchronized`
* **Returns:** `List<String>`
* Adds passenger to the waiting queue
* Logs ride request
* Initiates driver assignment

---

### 2. `assignDriver(int driverId)`

* **Type:** `synchronized`
* **Returns:** `void`
* Takes a driver ID as input
* Assigns the driver to a waiting passenger
* Logs assignment
* Calls ride completion

---

### 3. `completeRide(int passengerId, int driverId)`

* **Type:** `synchronized`
* **Returns:** `void`
* Simulates ride completion
* Logs completion
* Returns driver back to available pool

---

## 🔄 Execution Flow

1. Initialize drivers and add them to `availableDrivers`
2. For each passenger:

   * Submit a task using a thread pool
   * Call `requestRide(passengerId)`
3. Inside `requestRide`:

   * Passenger enters waiting queue
   * Wait for available driver
   * Driver is assigned
4. Ride is completed
5. Driver is returned to pool
6. Logs are maintained centrally

---

## 🧵 Concurrency Constraints

* All three methods must be **synchronized**
* Use:

  * `Queue` for drivers
  * `BlockingQueue` for passengers
* Use `wait()` and `notify()` for coordination
* Use a **virtual thread pool** (`Executors.newVirtualThreadPerTaskExecutor()`)

---

## 🖨️ Output Requirements

* Logs must include:

  * Ride request
  * Driver assignment
  * Ride completion
* Logs should be printed **only once after all threads complete**

---

## ⚠️ Edge Cases

* No available drivers → passengers must wait
* Multiple passengers requesting concurrently
* Ensure no duplicate or repeated logs

---

## ❌ Common Pitfalls

* Printing logs inside each thread (causes duplication)
* Using shared mutable state incorrectly
* Not synchronizing access to shared resources
* Using non-blocking queues where blocking is required

---

## ✅ Expected Output (Sample)

```
Passenger 1 requested ride
Driver 1 assigned to Passenger 1
Ride completed: Passenger 1 with Driver 1
...
```

---

## 💡 Follow-up Questions (Interview)

1. How would you remove `synchronized` and improve scalability?
2. What happens if we use `ConcurrentLinkedQueue`?
3. How would you ensure fairness in driver assignment?
4. How would you scale this to a real-world system like Uber?

---

## 🚀 Bonus Improvements

* Use `BlockingQueue` for drivers to remove manual synchronization
* Replace `wait()/notify()` with higher-level concurrency utilities
* Introduce timeout handling for passengers

---

## 🏁 Summary

This problem tests:

* Concurrency fundamentals
* Thread coordination
* Proper use of Java collections
* Handling shared state
* Writing clean, maintainable concurrent code

---

**End of Problem**


*/
package com.java.recruitme.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RideSystem {
	
	private final Queue<Integer> availableDrivers;
    private final BlockingQueue<Integer> waitingPassengers;
    private final List<String> logs;
    private final int numberOfDrivers;
    
    
    public RideSystem(int numberOfDrivers) {
		this.numberOfDrivers = numberOfDrivers;
		this.availableDrivers = new java.util.concurrent.ConcurrentLinkedQueue<>();
		this.waitingPassengers = new java.util.concurrent.LinkedBlockingQueue<>();
		this.logs = new java.util.ArrayList<>();
		
		// Initialize available drivers
		for (int i = 1; i <= numberOfDrivers; i++) {
			availableDrivers.add(i);
		}
	}
    
    public synchronized List<String> requestRide(int passengerId) throws InterruptedException {
    	try {
            logs.add("Passenger " + passengerId + " requested ride");

            waitingPassengers.put(passengerId);

            // get a driver first
            while (availableDrivers.isEmpty()) {
                wait();
            }

            int driverId = availableDrivers.poll();

            assignDriver(driverId); // pass driverId (as per constraint)

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return logs;
    }

    private synchronized void assignDriver(int driverId) throws InterruptedException {
    	int pId = waitingPassengers.take();

        logs.add("Driver " + driverId + " assigned to Passenger " + pId);

        completeRide(pId, driverId);
    }
    
    
    private synchronized void completeRide(int passengerId, int driverId)
            throws InterruptedException {

        //Thread.sleep(500); // simulate ride

        logs.add("Ride completed: Passenger " + passengerId +
                " with Driver " + driverId);

        availableDrivers.offer(driverId);
        notify();
    }
    
    
    public static void main(String[] args) throws Exception {

        int drivers = Integer.parseInt(args[0]);
        int passengers = Integer.parseInt(args[1]);

        if (drivers < 1 || drivers > 10) {
            throw new IllegalArgumentException("Drivers must be 1–10");
        }

        if (passengers < 1 || passengers > 20) {
            throw new IllegalArgumentException("Passengers must be 1–20");
        }

        RideSystem system = new RideSystem(drivers);

        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            List<Future<List<String>>> futures = new ArrayList<>();
            
            for (int i = 1; i <= passengers; i++) {
                int passengerId = i;

                futures.add(executor.submit(() ->
                        system.requestRide(passengerId)
                ));
            }

            // Print logs
            // ✅ Just wait for completion (DON'T print here)
            for (Future<List<String>> future : futures) {
                future.get();
            }
        }
        
        // ✅ Print logs ONLY ONCE
        for (String log : system.logs) {
            System.out.println(log);
        }
    }
}
