package com.java.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		int[] chocolates = { 1, 2, 3, 4, 5 };

		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * String name = br.readLine(); // Reading input from STDIN
		 * System.out.println("Hi, " + name + "."); // Writing output to STDOUT
		 */

		// Scanner
		List<Integer[]> list = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		int noOfTest = s.nextInt(); // Reading input from STDIN
		for (int j = 0; j < noOfTest * 2; j++) {
			String str = s.nextLine();

			String[] secondInput = str.split(" ");
			int[] intarr = new int[secondInput.length];
			intarr[0] = Integer.parseInt(secondInput[0]);
			intarr[1] = Integer.parseInt(secondInput[1]);
		}

		Arrays.sort(chocolates);
		int totalsum = getTotalSum(chocolates, 3, 0);
		System.out.println(totalsum);

	}

	private static int getTotalSum(int[] chocolates, int boxes, int count) {
		int sum = 0;
		for (int i = chocolates.length - 1; i >= count; i--) {
			sum += chocolates[i];
		}
		if (sum % boxes == 0) {
			return sum / boxes;
		} else {
			count++;
			return getTotalSum(chocolates, boxes, count);
		}
	}
}
