package com.java.recruitme.threads;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/*
 * producer should consume only when we have elements in the shared data structure 
 * other wise it should not be calling or pooling shared object.
 */
public class ProducerConsumerMain {

	public static void main(String[] args) {
		Sharedqueue sharedStream = new Sharedqueue();

		Thread consumerThread = new Thread(new ConsumerThread(sharedStream), "consumer");
		Thread producerThread = new Thread(new ProducerThread(sharedStream), "produer");

		producerThread.start();
		consumerThread.start();

		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("end");
	}
}

class ConsumerThread implements Runnable {

	private Sharedqueue sharedStream;

	public ConsumerThread(Sharedqueue sharedStream) {
		this.sharedStream = sharedStream;
	}

	public void run() {
		while (true) {
			// for (int i = 0; i < 10; i++) {
			System.out.println("consuming data - " + sharedStream.pollQueue());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ProducerThread implements Runnable {

	private Sharedqueue sharedStream;
	private Random random = new Random(10);
	// long[] arr = {1000, 2000, 3000, 4000, 5000, 6000, 5000, 4000, 3000, 2000,
	// 1000};
	long[] arr = { 1000, 6000, 1000 };
	int count = 0;

	public ProducerThread(Sharedqueue sharedStream) {
		this.sharedStream = sharedStream;
	}

	public void run() {
		while (true) {
			if (count == 3)
				count = 0;
			// for (int i = 0; i < 10; i++) {
			sharedStream.addToQueue(random.nextInt());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

class Sharedqueue {

	private Queue<Integer> queue;

	public Sharedqueue() {
		queue = new PriorityQueue<Integer>();
	}

	public void addToQueue(Integer random) {
		synchronized (this) {
			while (!this.queue.isEmpty()) {
				// System.out.println("queue is not empty...");
				waitCall();
				System.out.println("after wait called to release lock from producer");
			}
		}

		synchronized (this) {
			// System.out.println("queue size before adding : " + queue.size());
			queue.add(random);
			// System.out.println("producer time : " + System.currentTimeMillis() / (60 *
			// 1000F));
			System.out.println("producer random : " + random);
			notify();
			System.out.println("called notify.... in the add method");
		}
	}

	public Integer pollQueue() {

		int i;
		// System.out.println(" Thread.currentThread().holdsLock(getClass() " +
		// Thread.currentThread().holdsLock(getClass()));
		synchronized (this) {
			while (this.queue.isEmpty()) {
				// System.err.println(" queue is empty....");
				waitCall();
				System.err.println("  after wait called to release lock from consumer");
			}
		}

		synchronized (this) {
			// System.err.println(" queue size before pooling : " + queue.size());
			// System.err.println(" consumer random : " + queue.poll());

			i = queue.poll();
			System.out.println(queue.size());

			// System.err.println(" consumer time : " + System.currentTimeMillis() / (60 *
			// 1000F));
			// notify();
			// System.err.println(" called notify.... in the poll method");
		}
		return i;

	}

	private void waitCall() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
