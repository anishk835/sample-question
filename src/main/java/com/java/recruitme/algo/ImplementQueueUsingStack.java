package com.java.recruitme.algo;

import java.util.Stack;

public class ImplementQueueUsingStack {

	private static Stack<Integer> stack;

	public static void main(String[] args) {
		stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(printQueue());
		System.out.println(printQueue());
		System.out.println(printQueue());
	}

	private static void printQueue(Stack<Integer> stack) {
		if (!stack.empty()) {
			int a = stack.pop();
			printQueue(stack);
			System.out.println(a);
		} else {
			return;
		}
	}

	private static int printQueue() {

		if (stack == null)
			return -1;

		if (stack.size() == 1)
			return stack.pop();

		int currVal = stack.pop();

		int val = printQueue();

		stack.push(currVal);

		return val;

	}

}
