package com.java.threads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSafe {
	

	public static void main(String[] args) {
		/*
		 * Base base = new Base(); Derived derived = new Derived();
		 * 
		 * Thread th1 = new MyThread(base, "thread_base"); Thread th2 = new
		 * MyThread(derived, "thread_derived");
		 * 
		 * th1.start(); th2.start();
		for (int i = 0; i < 1000; i++) {
			new Thread(new CountBoxes()).start();
		}
		*/

		CountBoxes1 a = new CountBoxes1("A");
		CountBoxes1 b = new CountBoxes1("B");
		
		a.start();
		b.start();
	}

}

final class CountBoxes1 implements Runnable {
	
	private Thread t;
	private String st;
	public CountBoxes1(String str) {
		this.st = str;
	}

	public void run() {
		while(true)
			System.out.println(st);
	}
	
	public void start() {
		if(t == null) {
			t = new Thread(this, st);
			t.start();
		}
	}

	
}

final class CountBoxes implements Runnable {
	private static volatile int counter;
	// ...
	private final Object lock = new Object();

	public void run() {
		synchronized (lock) {
			//System.out.println("thread name - " + Thread.currentThread().getName() + " lock object - " + lock);
			System.out.println(counter++);
			// ...
		}
	}
	
	public void start() {
		System.out.println("------");
	}
}

class Base {

	static boolean flag = false;
	static SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");

	public Date parse(String str) throws ParseException {
		synchronized (getClass()) {
			System.out.println("the class is - " + getClass());
			System.out.println("in the parse base class -- " + Thread.currentThread().getName() + "  lock -- "
					+ Thread.holdsLock(Base.class) + "  current class lock -- " + Thread.holdsLock(getClass()));
			if (getClass().equals("com.java.ds.Derived"))
				flag = true;
			while (flag) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			return format.parse(str);
		}
	}
}

class Derived extends Base {
	public Date doSomethingAndParse(String str) throws ParseException {
		synchronized (Base.class) {
			System.out.println("in the doSomethingAndParse method derived class -- " + Thread.currentThread().getName()
					+ "  lock -- " + Thread.holdsLock(Base.class) + "  current class lock -- "
					+ Thread.holdsLock(getClass()));
			// ...
			return format.parse(str);
		}
	}
}

class MyThread1 extends Thread {

	private Object base;

	public MyThread1(Base base, String name) {
		this.base = base;
		setName(name);
	}

	@Override
	public void run() {
		if (base instanceof Derived) {
			System.out.println("derived block ...." + Thread.currentThread().getName());
			Derived derived = (Derived) base;
			try {
				System.out.println("derived output ..... " + derived.doSomethingAndParse("31-Dec-1998"));

				System.out.println("derived output calling parse..... " + derived.parse("31-Dec-1998"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("base block ...." + Thread.currentThread().getName());
			Base new_name = (Base) base;
			try {
				System.out.println("base output ....." + new_name.parse("31-Dec-1998"));
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}
}

class ReentrantLockTest {

	private boolean isLocked = false;

	public void lock() {

		while (isLocked) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isLocked = true;
	}

	public void unlock() {
		isLocked = false;
		notify();

	}
}
