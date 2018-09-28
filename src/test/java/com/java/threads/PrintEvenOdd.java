package com.java.threads;

import java.util.HashSet;
import java.util.Set;

public class PrintEvenOdd {

	public static void main(String[] args) {
		
		String s1 = new String("abc");
		String s2 = new String("abc");
		String s3 = new String("abc");
		String s4 = "abc";

		Set<String> set = new HashSet<String>();
		set.add(s1);
		set.add(s2);
		set .add(s3);
		set.add(s4);
		
		System.out.println("set size - " + set.size());
		SharedObject object = new SharedObject();

		Thread th_even = new Thread(new Even(object), "even_thread");
		Thread th_odd = new Thread(new Odd(object), "odd_thread");

		th_even.start();
		th_odd.start();
	}
}

class Even implements Runnable {

	private SharedObject sharedObject;

	public Even(SharedObject obj) {
		this.sharedObject = obj;
	}

	public void run() {
		while (true) {
			this.sharedObject.printEven();
		}
	}

}

class Odd implements Runnable {

	private SharedObject sharedObject;

	public Odd(SharedObject obj) {
		this.sharedObject = obj;
	}

	public void run() {
		while (true) {
			this.sharedObject.printOdd();
		}
	}

}

class SharedObject {

	private int i;
	private boolean flag = false;

	public void printEven() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		synchronized (this) {
			while (!flag) {
				System.out.println("even num - " + i);
				try {
					
					flag = true;
					i++;
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// System.out.println("i value from even block - " + i);
			}
			System.out.println("i value from even block - " + i);

		}
	}

	public void printOdd() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		synchronized (this) {
			while (flag) {
				System.err.println("odd num - " + i);
				i++;
				flag = false;
				notify();

				// System.out.println("i value from odd block - " + i);
			}

		}

	}
}