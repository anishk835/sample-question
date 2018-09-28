package com.java.recruitme.primes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Prime {

	public List<Integer> findPrimes(int n) {
		List<Integer> list = new ArrayList<Integer>();

		if (n <= 1)
			return Collections.emptyList();

		if (n == 0)
			return Collections.emptyList();
		if (n == 1) {
			list.add(1);
			return list;
		}
		for (int i = 2; i <= n; i++) {

			if (isPrime(i))
				list.add(i);
		}

		return list;
	}

	/*
	static void isPrime(int n, List<Integer> list) {
		
		Iterator<Integer> iterator = list.iterator();
		  
		  while(iterator.hasNext()){ System.out.println(iterator.next());
		  
		  int integer = iterator.next();
		  
		int local = n;
		boolean flag = false;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				if (!flag)
					list.add(local);
				flag = true;
			}
		}

	}
	*/

	static boolean isPrime(int n) {
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		List<Integer> primes = new Prime().findPrimes(20);
		System.out.println(primes);
	}
}
