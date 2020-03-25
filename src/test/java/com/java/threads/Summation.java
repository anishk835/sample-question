package com.java.threads;

import java.math.BigInteger;

public class Summation implements Runnable {

	private BigInteger start;
	private BigInteger end;
	private volatile BigInteger sum;

	public Summation(BigInteger start, BigInteger end) {
		this.start = start;
		this.end = end;
		this.sum = new BigInteger("0");
	}

	@Override
	public void run() {
		for (BigInteger i = start; i.compareTo(end) <= 0; i.add(new BigInteger("1"))) {
			sum = sum.add(i);
		}
		System.out.println( "from the run method  " + Thread.currentThread().getName());
	}

	public BigInteger getSum() {
		return sum;
	}

}