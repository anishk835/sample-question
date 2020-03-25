package com.java.threads;

public class SharedThreadB extends Thread {

	Shared shared;
	String name;
	
	public SharedThreadB(Shared shared, String name) {
		this.shared = shared;
		this.name = name;
	}
	
	@Override
	public void run() {
		shared.test2(name);
	}
}
