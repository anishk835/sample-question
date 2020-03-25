package com.java.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {
	public static void main(String[] args) throws IOException {

		int[][][] cube = new int[3][3][3];
		for (int[][] square : cube) {
			for (int[] line : square) {
				Arrays.fill(line, 0);
			}
		}

		System.out.println("-----");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		long P = Long.parseLong(inp[1]);
		int[] A = new int[N];
		String[] inp1 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(inp1[i]);
		}

		long out_ = solve(N, P, A);
		System.out.println(out_);

		wr.close();
		br.close();
	}

	static void calculatePower(List<Integer> list, int totalStrength, int powerLost, boolean flag) {

		if (list.size() == 2)
			return;

		int count = 1;
		totalStrength += getPower(count, list);
		powerLost += list.get(count);
		list.remove(count);
		calculatePower(list, totalStrength, powerLost, false);
	}

	static int[][][] power = new int[3][3][3];

	static {
		int pow = 1;
		for (int[][] square : power) {
			for (int i = 0; i < square.length; i++) {
				for (int j = 0; j < square[0].length; j++) {
					square[i][j] = (int) Math.pow(pow, Math.pow(i, j));
				}
			}
			pow++;
		}
	}

	static long solve(int N, long P, int[] A) {

		// exclude 1 power
		int totalStrength = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i] != 1) {
				list.add(A[i]);
			} else {
				totalStrength += 1;
			}
		}

		boolean[] visited = new boolean[A.length];
		Arrays.fill(visited, false);

		int powerLost = 0;

		calculatePower(list, totalStrength, powerLost, false);

		/*
		 * 
		 * boolean[] visited = new boolean[A.length]; Arrays.fill(visited, false); int
		 * startIndex = 1;
		 * 
		 * while (totalStrength < P) {
		 * 
		 * List<Integer> list = new ArrayList<>(); for (int i = 0; i < list.size(); i++)
		 * { if (!visited[i]) list.add(A[i]); } for (Integer integer : A) {
		 * list.add(integer); }
		 * 
		 * visited[startIndex] = true;
		 * 
		 * Iterator<Integer> iterator = list.iterator(); int count = 1; while
		 * (iterator.hasNext() && count < list.size() - 1) { int val = iterator.next();
		 * if (val != 1) totalStrength += getPower(count, list); else totalStrength +=
		 * 1; powerLost += val; count++; iterator.remove(); }
		 * 
		 * if (totalStrength >= P) { break; } startIndex++; totalStrength = 0; powerLost
		 * = 0; Arrays.fill(visited, false); }
		 */

		return P - totalStrength + powerLost;
	}

	static long getPower(int i, List<Integer> list) {
		long power = (long) Math.pow(list.get(i - 1), list.get(i + 1));
		return (long) Math.pow(list.get(i), power);
	}
}