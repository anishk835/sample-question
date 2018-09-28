package com.java.recruitme.algo;

import java.util.Arrays;

public class DijkstraAlgo {

	private static int VERTEX = 9;

	public static void main(String[] args) {

		int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
			{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };;
		int src = 0;
		getShortestPath(graph, src);
	}

	private static void getShortestPath(int[][] graph, int src) {

		int[] dist = new int[VERTEX];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Boolean sptSet[] = new Boolean[VERTEX];
		Arrays.fill(sptSet, Boolean.FALSE);

		dist[src] = 0;

		int min_index = src;

		for (int i = 0; i < graph.length; i++) {

			min_index = getMinIndex(dist, sptSet);

			sptSet[min_index] = true;

			for (int j = 0; j < graph[i].length; j++) {

				if (!sptSet[j] && graph[min_index][j] != 0 && dist[min_index] != Integer.MAX_VALUE
						&& dist[min_index] + graph[min_index][j] < dist[j]) {

					dist[j] = dist[min_index] + graph[min_index][j];
				}
			}
		}
		
		for (int i = 0; i < 9; i++)
			System.out.println(i + " tt " + dist[i]);
	}

	private static int getMinIndex(int[] dist, Boolean[] sptSet) {
		// TODO Auto-generated method stub
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < VERTEX; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

}
