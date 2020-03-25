package com.java.threads;

import java.util.List;

public class PrintNumberAndString {

}

class Print extends Thread {
	
	private String str;
	private int[] arr;
	List<String> list;
	
	public Print(String str) {
		this.str = str;
	}
	
	public Print(int[] arr) {
		assert arr != null;
		this.arr = arr;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
	}
	
	private synchronized void printString() {
		String[] strarray = this.str.split(" ");
		for (String string : strarray) {
			System.out.println(string);
		}
	}
	
	private synchronized void printInteger() {
		for (int i : this.arr) {
			System.out.println(i);
		}
	}
}