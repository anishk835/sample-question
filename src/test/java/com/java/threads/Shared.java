package com.java.threads;

public class Shared {

	public static void main(String[] args) {
		
		String str = "Anish";
		str.replace("Anish", "Kumar");
		System.out.println(str);
		
		String st = str.replaceAll("Anish", "Kumar");
		System.out.println(st);
		final ThreadSync sync = new ThreadSync();
		/*
		sync.print("Anish Kumar");
		sync.printA("Anish Kumar");
		sync.printB("Anish Kumar");
		sync.printC("Anish Kumar");
		ThreadSync.printB("Anish Kumar");

	*/
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sync.print("Anish");

			}
		},"th1");;
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sync.printA("Kumar");

			}
		},"th2");
		Thread th3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sync.printB("Nokia");

			}
		},"th3");
		Thread th4 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sync.printC("Manyata");

			}
		},"th4");
		Thread th5 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sync.printD("Manyata_1");

			}
		},"th5");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
	}

	public void test1(String name) {
		Thread th = Thread.currentThread();
		for (int i = 0; i < 100; i++) {
			System.out.println("test1 - " + name + " : " + th.getName() + " : " + i);
		}
	}

	public void test2(String name) {
		Thread th = Thread.currentThread();
		for (int i = 0; i < 100; i++) {
			System.out.println("test1 - " + name + " : " + th.getName() + " : " + i);
		}
	}
}

class ThreadSync {

	public void print(String str) {
		System.out.println("current thread - " + Thread.currentThread().getName() + " status "
				+ Thread.currentThread().getState() + " value of string is - " + str);
	}

	public void printA(String str) {
		synchronized (this) {
			System.out.println("current thread - " + Thread.currentThread().getName() + " status "
					+ Thread.currentThread().getState() + " value of string is - " + str);
			
			
			/*
			try {
				Thread.sleep(1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			Thread th = Thread.currentThread();
			for (int i = 0; i < 100; i++) {
				//System.out.println(th.getName() + " : " + i);
			}
		}
		
	}

	public static synchronized void printB(String str) {
		System.out.println("current thread - " + Thread.currentThread().getName() + " status "
				+ Thread.currentThread().getState() + " value of string is - " + str);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized void printD(String str) {
		System.out.println("current thread - " + Thread.currentThread().getName() + " status "
				+ Thread.currentThread().getState() + " value of string is - " + str);
	}

	public synchronized void printC(String str) {
		System.out.println("current thread - " + Thread.currentThread().getName() + " status "
				+ Thread.currentThread().getState() + " value of string is - " + str);
		Thread th = Thread.currentThread();
		for (int i = 0; i < 100; i++) {
			//System.out.println(th.getName() + " : " + i);
		}
	}
}
