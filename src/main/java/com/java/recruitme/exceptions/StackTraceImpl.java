package com.java.recruitme.exceptions;

import com.java.recruitme.services.StackTrace;

public class StackTraceImpl implements StackTrace {
	public void clearStackTrace() throws Exception {
		try {
			method1();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("clearStackTrace");
		}
	}

	private void method1() throws Exception {
		method2();
	}

	private void method2() throws Exception {
		method3();
	}

	private void method3() throws Exception {
		throw new Exception("Exceptiom from method3");
	}
}
