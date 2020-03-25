package com.java.recruitme;

/**
 * Covert given string to integer value
 * @author anishkumar
 *
 */
public class Convertstringtointeger {

	public static void main(String[] args) {
		String str = args[0];
		int res = getIntegerValue(str);
		System.out.println(res);
	}

	private static int getIntegerValue(String str) {
		if(null == str)
			return -1;
		char[] c = str.toCharArray();
		int val = 0;
		int size = c.length;
		for (int i = 0; i < c.length; i++) {
			val += (c[i] - '0' )* Math.pow(10, --size);
		}
		return val;
	}
}
