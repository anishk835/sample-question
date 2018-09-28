package com.java.threads;

import java.lang.reflect.Field;

public class ReflectionUsingString {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// add "Hello" to pool
        String hello = "Hello";
 
        // Change value of "Hello" string to "Buy Buy"
        Field value = hello.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(hello, "Buy buy".toCharArray());
 
        // Print "Hello" to console
        System.out.println("Hello");
	}
}
