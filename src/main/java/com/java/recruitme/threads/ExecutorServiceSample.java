package com.java.recruitme.threads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import com.java.recruitme.*;

public class ExecutorServiceSample {


	public static void main(String[] args) {

		try {
			List<List<Integer>> integerArrays = loadDataFromFile();

			ConcurrentHashMap<String, Integer> sumMap = calculateUsingThreads(integerArrays);
			System.out.println("Multi-Threaded sum");
			printSumMap(sumMap);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static ConcurrentHashMap<String, Integer> calculateUsingThreads(List<List<Integer>> integerArrays) {

		ConcurrentHashMap<String, Integer> sumMap = new ConcurrentHashMap<>(integerArrays.size());

		List<Thread> threads = new ArrayList<>();
		int i = 1;

		// Create thread instances for each array
		for (List<Integer> integers : integerArrays) {

			String arrayName = "Array " + i;

			Thread thread = new Thread(new ArraySumCalculator(sumMap, integers, arrayName));
			threads.add(thread);
			i++;
		}

		// Now launch all the threads at the same time
		for (Thread thread : threads) {
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		return sumMap;
	}

	private static List<List<Integer>> loadDataFromFile() throws IOException {
		Path path = Paths.get("/Users/anishkumar/Documents/Workspace/target-case-study/src/main/resources/array.txt");
		List<String> linesInFile = Files.readAllLines(path, Charset.defaultCharset());
		List<List<Integer>> arrays = new ArrayList<>();
		for (String s : linesInFile) {
			String[] sArray = s.split(",");
			List<Integer> integers = new ArrayList<>();
			for (String sInt : sArray) {

				integers.add(Integer.parseInt(sInt));

			}
			arrays.add(integers);
		}

		return arrays;
	}

	private static void printSumMap(ConcurrentHashMap<String, Integer> sumMap) {
		List<String> mapKeys = Collections.list(sumMap.keys());
		Collections.sort(mapKeys, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] o1Array = o1.split(" ");
				String[] o2Array = o2.split(" ");
				Integer o1Int = Integer.parseInt(o1Array[1]);
				Integer o2Int = Integer.parseInt(o2Array[1]);
				return o1Int.compareTo(o2Int);
			}
		});
		for (String s : mapKeys) {
			System.out.println(s + ":" + sumMap.get(s));
		}
	}
}
