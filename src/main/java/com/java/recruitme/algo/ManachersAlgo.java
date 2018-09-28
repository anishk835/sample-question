package com.java.recruitme.algo;

public class ManachersAlgo {

	public static void main(String[] args) {

		String str = "ABABABA";

		String string = "#";
		for (char c : str.toCharArray()) {
			string += c + "#";
		}

		System.out.println(string);
		int len = getMaxLength(string);
		System.out.println("max length pallendrom is - " + len);
	}

	private static int getMaxLength(String string) {
		// r right most pointer
		// c center line
		int r = 0, c = 0;
		int[] arr = new int[string.length()];
		arr[0] = 0;
		for (int i = 1; i < string.length(); i++) {

			int mirror = 2 * c - i;

			if (i < r)
				arr[i] = Math.min(r - i, arr[mirror]);

			// expansion around character
			int leftcout = i - 1;
			int rightcount = i + 1;
			while (leftcout >= 0 && rightcount < string.length()
					&& string.charAt(leftcout) == string.charAt(rightcount)) {
				arr[i]++;
				leftcout--;
				rightcount++;
			}

			if (i + arr[i] > r) {
				c = i;
				r = i + 1;
			}

		}

		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxLen) {
				maxLen = arr[i];
				centerIndex = i;
			}
		}
		return maxLen;
	}
}
