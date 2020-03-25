package com.java.recruitme;

public class ConvertIntegerToRoman {

	private static String[] roman = { "M", "DM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	private static int[] integrals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	public static void main(String[] args) {
		String str = args[0];
		String res = getRomanLetter(Integer.valueOf(str));
		System.out.println(res);
	}

	public static String getRomanLetter(int i) {
		StringBuilder sb;
		if(i < 5000 && i > 1) {
			sb = new StringBuilder();
			
			int pos = 0;
			while(i > 0) {
				if(i - integrals[pos] >= 0) {
					sb.append(roman[pos]);
					i -= integrals[pos];
				} else {
					pos++;
				}
			}
			
		} else {
			throw new IllegalArgumentException();
		}
		return sb.toString();
	}
}
