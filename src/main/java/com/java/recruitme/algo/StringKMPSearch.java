package com.java.recruitme.algo;

import java.util.Arrays;

public class StringKMPSearch {

	public static void main(String[] args) {

		String pattern = "ABABCABAB";

		int[] arr1 = new int[pattern.length()];

		int[] arr = generateLps(pattern);

		computeLPSArray(pattern, pattern.length(), arr1);
		System.out.println("arr1 is - " + Arrays.toString(arr1));

		//System.out.println(Arrays.toString(arr));

		String text = "ABABDABACDABABCABAB";
		
		System.out.println(Arrays.toString(text.toCharArray()));
		System.out.println(Arrays.toString(pattern.toCharArray()));
		
		
		kmp(text, pattern);

		int j = 0;
		for (int i = 0; i < text.length();) {

			if (pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}
			if (j == pattern.length()) {
				System.out.println("index of pattern matched is at -  " + (i - j));
				j = arr1[j - 1];
			}
			if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
				if (j != 0) {
					j = arr1[j - 1];
				} else {
					i = i + 1;
				}
			}
		}

	}

	private static void kmp(String text, String pattern) {
		int i=0, j=0;
		while(i< text.length()) {
			
		}
		
	}

	private static int[] generateLps(String pattern) {
		int[] lps = new int[pattern.length()];
		int i = 0;
		int j = 1;
		while (j < pattern.length()) {

			if (pattern.charAt(i) == pattern.charAt(j)) {
				lps[j] = i + 1;
				i++;
				j++;
			} else {
				if (i != 0) {
					i = lps[i - 1];
				} else {
					j++;
					// lps[j] = 0;
				}

			}

		}

		return lps;
	}

	static void computeLPSArray(String pat, int M, int lps[]) {
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else // (pat[i] != pat[len])
			{
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (len != 0) {
					len = lps[len - 1];

					// Also, note that we do not increment
					// i here
				} else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}
}
