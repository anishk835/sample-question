package com.java.recruitme.threads;

public class Printoddevenusinglockonobect {
	public static void main(String[] args) {

		Printer printer = new Printer();

		MyRunnable r1 = new MyRunnable(true, printer);// isOdd = true
		Thread t1 = new Thread(r1, "odd");
		MyRunnable r2 = new MyRunnable(false, printer);// isOdd = false
		Thread t2 = new Thread(r2, "even");
		t1.start();
		t2.start();
	}
}

class Printer {
	private Object lock = new Object();
	private volatile boolean isOdd = false;

	public void printEven(int number) throws InterruptedException {
		synchronized (lock) {
			System.out.println("called even print function........");
			while (isOdd == false) {
				lock.wait();
			}
			System.out.println("even : " + number);
			isOdd = false;
			lock.notifyAll();
		}
	}

	public void printOdd(int number) throws InterruptedException {
		synchronized (lock) {
			System.out.println("called odd print function........");
			while (isOdd == true) {
				lock.wait();
			}
			System.out.println("odd : " + number);
			isOdd = true;
			lock.notifyAll();
		}
	}
}

class MyRunnable implements Runnable {

	private boolean isOdd;
	Printer printer;

	MyRunnable(boolean isOdd, Printer printer) {
		this.isOdd = isOdd;
		this.printer = printer;
	}

	public void run() {
		int number = isOdd == true ? 1 : 2;
		while (number <= 10) {
			if (isOdd) {
				try {
					printer.printOdd(number);
				} catch (InterruptedException e) {
				}
			} else {
				try {
					printer.printEven(number);
				} catch (InterruptedException e) {
				}
			}
			System.out.println("called to increment number.......");
			number += 2;
			System.out.println("called to increment number......." + number);
		}
	}
}