package codechef;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

class Codechef_ZCO15004 {

	public static void main(String[] args) throws java.lang.Exception {
		/*
		 * while (true) { try { computeArea(); } catch (Exception e) { return; } }
		 */
		computeArea();
	}

	private static void computeArea() {
		Scanner sc = new Scanner(System.in);
		Point[] points = new Point[sc.nextInt() + 2];
		points[0] = new Point(0, 0); // First x point
		points[points.length - 1] = new Point(100000, 0); // Last x point
		int i = 1;
		while (i < points.length - 1) {
			sc.nextLine();
			points[i++] = new Point(sc.nextInt(), sc.nextInt());
		}
		sc.close();
		Arrays.sort(points, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.getx() - o2.getx();
			}
		});
		int[] right = new int[points.length];
		int[] left = new int[points.length];
		Stack<Integer> stk = new Stack<Integer>();
		for (int j = 0; j < points.length; j++) {
			while (!stk.isEmpty()) {
				if (points[stk.peek()].gety() > points[j].gety())
					right[stk.pop()] = points[j].getx();
				else
					break;
			}
			stk.add(j);
		}
		for (int j = points.length - 1; j >= 0; j--) {
			while (!stk.isEmpty()) {
				if (points[stk.peek()].gety() > points[j].gety())
					left[stk.pop()] = points[j].getx();
				else
					break;
			}
			stk.add(j);
		}

		int maxArea = -1;

		for (int j = 0; j < points.length; j++) {
			maxArea = Math.max(maxArea, (right[j] - left[j]) * points[j].gety());
		}
		for (int j = 0; j < points.length - 1; j++) {
			maxArea = Math.max(maxArea, (points[j + 1].getx() - points[j].getx()) * 500);
		}
		System.out.printf("Max area is: %d", maxArea);
	}
}

class Point {

	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
