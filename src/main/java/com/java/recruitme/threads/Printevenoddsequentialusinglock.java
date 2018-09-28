package com.java.recruitme.threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printevenoddsequentialusinglock {

	public static void main(String[] args) {
		
		EvenOddNumberClass numberPrint = new EvenOddNumberClass();
		Thread even_th = new PrintEvenThread(numberPrint, "even", true);
		Thread odd_th = new PrintOddThread(numberPrint, "odd", false);
		
		System.out.println("even thread state  - " + even_th.getState());
		System.out.println("odd thread state  - " + odd_th.getState());
		try {
			even_th.join();
			odd_th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class PrintEvenThread extends Thread {

	private EvenOddNumberClass numberPrint;
	private boolean flag;

	public PrintEvenThread(EvenOddNumberClass numberPrint, String string, boolean flag) {
		this.numberPrint = numberPrint;
		this.flag = flag;
		setName(string);
		start();
	}


	@Override
	public synchronized void run() {
		numberPrint.printEven();
	}
}

class PrintOddThread extends Thread {

	private EvenOddNumberClass numberPrint;
	private boolean flag;

	public PrintOddThread(EvenOddNumberClass numberPrint, String string, boolean flag) {
		this.numberPrint = numberPrint;
		this.flag = flag;
		setName(string);
		start();
	}

	@Override
	public void run() {
		numberPrint.printOdd();
	}
}

class EvenOddNumberClass {

	boolean flag = false;
	private int i = 0;
	private Lock lock = new ReentrantLock();
	
	/*
	public void printEven() {
		System.out.println("thread name " + Thread.currentThread().getName() + " and boolean flag is - " + flag);
		synchronized (this) {
			while (i < 10) {

				lock.lock();
				if (i % 2 == 0)
					System.out.println(i);
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;

				lock.unlock();
			}
		}
	}

	public void printOdd() {
		System.out.println("thread name " + Thread.currentThread().getName() + " and boolean flag is - " + flag);
		synchronized (this) {
			while (i < 10) {

				lock.lock();
				if (i % 2 != 0)
					System.out.println(i);

				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
				notify();
				lock.unlock();
			}
		}
	}
	*/
	
	
	
	public void printEven() {
		System.out.println("thread name " + Thread.currentThread().getName() + " and boolean flag is - " + flag);
		synchronized (this) {
			while (i < 100) {

				while (flag) {
					try {
						System.out.println("even waiting : " + i);
						wait();
						System.out.println("Notified even :" + i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (i % 2 == 0)
					System.out.println("thread name - " + Thread.currentThread().getName() + " value - " +  i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;

				flag = true;
				notify();

			}
		}
	}

	public void printOdd() {
		AtomicInteger atomicInteger = new AtomicInteger(123);
		int $x3;
		//System.out.println("thread name " + Thread.currentThread().getName() + " and boolean flag is - " + flag);
		synchronized (this) {
			while (i < 100) {
				System.out.println("Checking odd loop");

				while (!flag) {
					try {
						System.out.println("Odd waiting : " + i);
						wait();
						System.out.println("Notified odd :" + i);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (i % 2 != 0)
					System.out.println(i);
				System.out.println("Odd Thread :" + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
				flag = false;
				notify();
			}
		}
	}
	
}

