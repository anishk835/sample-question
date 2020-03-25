package com.java.threads;

class C {

	public int j = 10;

	public void test() {
		System.out.println("called form C");
		j = 30;
	}
}

class B extends C {
	public void test() {
		System.out.println("called form C");
	}
}

public class A extends B {

	public A(int j) {
		System.out.println(j);
	}

	public A() {
		System.out.println("default");
		j = 60;
	}

	static int i = 40;

	public static void main(String[] args) {
		A a = new A(63);
		a.i = 30;
		System.out.println(a.i);
		System.out.println(a.j);

		int c = 0, b = 0, d = 0;

		System.out.println("value of c pre increment operator - " + ++c);

		System.out.println("value of c pre increment - " + c);

		System.out.println("value of c post increment operator - " + d++);

		System.out.println("value of c post increment - " + d);

		int m = ++c | ++b & ++d;

		System.out.println("m value is - " + m);

		try {
			if (false) {
				while (true) {

				}
			} else {
				System.out.println("Anish exit 1 ");
				System.exit(10);
				System.out.println("Anish exit 2 ");
			}
		} finally {
			System.out.println("Anish exit ");
		}

		/*
		 * double a1 = 295.04; int b = 300; byte c = (byte) a1; byte d = (byte) b;
		 * System.out.println(c + " " + d);
		 */

		Thread t1 = new Thread("t!");
		Thread t2 = new Thread("t2");

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * TreeSet<StringBuffer> t=new TreeSet<StringBuffer>(); t.add(new
		 * StringBuffer("H")); t.add(new StringBuffer("A")); t.add(new
		 * StringBuffer("C")); t.add(new StringBuffer("K")); System.out.println(t);
		 */
	}

}
