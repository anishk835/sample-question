package com.java.recruitme.jmx;

import java.io.Serializable;
import java.lang.instrument.Instrumentation;

public class InstrumentAgent {

	private static volatile Instrumentation globalInstrumentation;

	public static void premain(final String agentArgs, final Instrumentation inst) {
		globalInstrumentation = inst;
	}

	public static long getObjectSize(final Object object) {
		if (globalInstrumentation == null) {
			throw new IllegalStateException("Agent not initialized.");
		}
		return globalInstrumentation.getObjectSize(object);
	}

	public static void main(String[] args) {
		Person person = new Person();
		long l = getObjectSize(person);
		System.out.println("person object size - " + l);
	}
}

class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3973629406848422442L;

}
