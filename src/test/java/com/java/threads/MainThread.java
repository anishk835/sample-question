package com.java.threads;

import java.math.BigInteger;
import java.util.Arrays;

public class MainThread {

	public static void main(String[] args) {
		
		Integer.valueOf("1");

		int threadCount = 3;

		int[] arr = new int[100000000];
		Arrays.fill(arr, 1);

		long start = 0;

		Summation[] sumThreads = new Summation[threadCount];
		long steps = (start - arr.length) / threadCount;

		for (int i = 0; i < threadCount; i++) {
			long begin = start + steps * i;
			long end = (start + steps) - 1;

			if (i == threadCount - 1)
				end = arr.length;
			System.out.printf("Thread %d sums from %d to %d.\n", i, start, end);
			sumThreads[i] = new Summation(BigInteger.valueOf(begin), BigInteger.valueOf(end));
			start = end;
		}

		Thread[] thread = new Thread[threadCount];
		for (int i = 0; i < threadCount; i++) {
			Thread th = new Thread(sumThreads[i]);
			System.out.println("thread name - " + th.getName());
			thread[i] = th;
			th.start();
			try {
				thread[i].join();
				//System.out.println(thread[1].getName() + " " + thread[1].getState());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("thread size " + thread.length);
		/*
		for(int i=0; i<threadCount; i++) {
			try {
				thread[i].join();
				System.out.println(thread[1].getName() + " " + thread[1].getState());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		
		//Thread.currentThread().notifyAll();
		
		BigInteger total_sum = BigInteger.ZERO;
	    for(int i = 0; i < threadCount; i++) {
	      total_sum.add(sumThreads[i].getSum( ));
	    }
	    
	    System.out.printf("The sum of %s-%s is %s.\n", 0, arr.length, total_sum.toString( ));
	}
}
