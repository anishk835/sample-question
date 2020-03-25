package com.java.threads;

public class SharedThreadA extends Thread {

	Shared shared;
	String name;
	
	public SharedThreadA(Shared shared, String name) {
		this.shared = shared;
		this.name = name;
	}
	
	@Override
	public void run() {
		shared.test1(name);
	}
}
