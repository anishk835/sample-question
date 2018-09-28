package com.java.recruitme.algo;

class StackObjectUsingSingleArray {

	private int[] arr;

	private int LENGTH = 10;

	// Holding the current capacity
	private int currentCapacityOne;
	private int currentCapacityTwo;

	// Holding the index for both the stack
	private int topStack1index;
	private int topStack2index;

	private int capacityRatio = 2;

	// Each stack size after partition
	private int eachStackSize;

	public StackObjectUsingSingleArray() {
		arr = new int[LENGTH];

		topStack1index = 0;
		topStack2index = LENGTH / 2;

		currentCapacityOne = 0;
		currentCapacityTwo = 0;

		eachStackSize = LENGTH / 2;
	}

	void push1(int obj) {
		if (currentCapacityOne < eachStackSize) {
			// Index get incremented for stack 1
			arr[topStack1index++] = obj;
			// current capacity for stack 1
			currentCapacityOne++;
		} else {
			// Write resize of array
			resizeArray();
			// Adding element after partition of new array.
			arr[topStack1index] = obj;
			topStack1index++;
			currentCapacityOne++;
		}
	}

	private void resizeArray() {
		int[] temp = arr;
		int newSize = LENGTH * capacityRatio;
		LENGTH = newSize;
		arr = new int[newSize];
		eachStackSize = newSize / 2;

		// Adding element for stack 1
		// copy first partition of array and for stack 1 index is already
		// maintained
		if (currentCapacityOne > 0) {
			for (int i = 0; i < topStack1index; i++) {
				arr[i] = temp[i];
			}
		} else {
			topStack1index = 0;
		}

		// Adding element for stack 2
		if (currentCapacityTwo > 0) {

			int currentTempIndex = temp.length / 2;
			int maxLimit = eachStackSize + temp.length / 2;

			for (int i = eachStackSize; i < maxLimit; i++) {
				arr[i] = temp[currentTempIndex];
				currentTempIndex++;
			}

			// Adjust the index for stack 2
			topStack2index = maxLimit;
		} else {
			topStack2index = eachStackSize;
		}
	}

	void push2(int obj) {
		if (currentCapacityTwo < eachStackSize) {
			// Index get incremented for stack 2
			arr[topStack2index++] = obj;
			// current capacity for stack 2
			currentCapacityTwo++;
		} else {
			resizeArray();
			arr[topStack2index] = obj;
			topStack2index++;
			currentCapacityTwo++;
		}
	}

	int pop1() throws Exception {
		int val = -1;
		if (currentCapacityOne > 0) {
			val = arr[topStack1index - 1];
			// Empty the space by setting -1 value
			arr[topStack1index - 1] = -1;

			// Decrement the index for stack 1
			topStack1index--;

			// decrement capacity for stack 1
			currentCapacityOne--;
		} else {
			throw new Exception("Stack 1 is empty !!");
		}
		return val;
	}

	int pop2() throws Exception {
		int val = -1;
		if (currentCapacityTwo > 0) {
			val = arr[topStack2index - 1];
			// Empty the space by setting -1 value
			arr[topStack2index - 1] = -1;
			// Decrement the index for stack 2
			topStack2index--;
			// decrement capacity for stack 2
			currentCapacityTwo--;
		} else {
			throw new Exception("stack 2 is empty !!");
		}
		return val;
	}
}