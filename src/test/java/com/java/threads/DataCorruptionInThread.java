package com.java.threads;

public class DataCorruptionInThread {

	public static void main(String[] args) {
		
		//Shared s1 = new Shared();
		
		Shared sB = new Shared();
		
		SharedThreadB t1 = new SharedThreadB(sB, "SharedThreadB") ;
		SharedThreadB t2 = new SharedThreadB(sB, "SharedThreadB");
		
		SharedThreadB t3 = new SharedThreadB(sB, "SharedThreadB");
		SharedThreadB t5 = new SharedThreadB(sB, "SharedThreadB");
		SharedThreadB t4 = new SharedThreadB(sB, "SharedThreadB");
		t1.start();
		t2.start();
		
		t3.start();
		t4.start();
		t5.start();
	}
}
