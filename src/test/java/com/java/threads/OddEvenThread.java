package com.java.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenThread {

	public static void main(String[] args) {
		/*
		Semaphore semaphore = new Semaphore(2);
		OddThread oddThread = new OddThread(semaphore);
		EvenThread evenThread = new EvenThread(semaphore);
		*/
		TestOddEven testOddEven = new TestOddEven();
		Thread th1 = new PrintThread(testOddEven,"even");
		Thread th2 = new PrintThread(testOddEven,"odd");
		
		th1.start();
		th2.start();
	}
}

class TestOddEven {
	
	private Lock lock = new ReentrantLock();
	
	
	synchronized void printEven() {
		
		for(int i=0;i<10; i+=2) {
			lock.lock();
			System.out.println(i);
			lock.unlock();
			
		}
	}
	
	synchronized void printOdd() {
		for(int i=1;i<10; i+=2) {
			lock.lock();
			System.out.println(i);
			lock.unlock();
			
		}
	}
}

class PrintThread extends Thread {
	
	private TestOddEven testOddEven;
	private Semaphore semaphore;
	private String str;
	
	public PrintThread(TestOddEven testOddEven, String string) {
		this.testOddEven = testOddEven;
		this.str = string;
		this.semaphore = new Semaphore(1);
	}
	
	@Override
	public void run() {
		try {
			semaphore.acquire(1);
			
			if(Thread.currentThread().getName().equals(this.str)) {
				testOddEven.printEven();
			}else {
				testOddEven.printOdd();
			}
			
			
			semaphore.release(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class OddThread extends Thread {
	
	private Semaphore semaphore;
	
	public OddThread(Semaphore semaphore) {
		this.semaphore = semaphore;
		start();
	}
	
	@Override
	public void run() {
		try {
			semaphore.acquire(1);
			for(int i=1;i<10; i+=2)
				System.out.println(i);
			semaphore.release(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class EvenThread extends Thread {

	private Semaphore semaphore;
	
	public EvenThread(Semaphore semaphore) {
		// TODO Auto-generated constructor stub
		this.semaphore = semaphore;
		start();
	}
	
	@Override
	public void run() {
		try {
			semaphore.acquire(0);
			for(int i=0;i<10; i+=2)
				System.out.println(i);
			semaphore.release(1);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
