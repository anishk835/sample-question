package com.java.recruitme.threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;

public class InterThreadCommunication {

	private InterThreadCommunication() {

	}

	public static void main(String[] args) {
		PipedOutputStream pipedOutputStream = null;
		PipedInputStream pipedInputStream = null;
		try {
			pipedOutputStream = new PipedOutputStream();
			pipedInputStream = new PipedInputStream(pipedOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread num_gen_th = new NumberGeneration(pipedOutputStream);
		Thread run_avg_th = new RunningAverage(pipedInputStream);

		try {
			num_gen_th.join();
			run_avg_th.join();
		} catch (InterruptedException e) {

		}

		try {
			if (pipedOutputStream != null)
				pipedOutputStream.close();
			if (pipedInputStream != null)
				pipedInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class NumberGeneration extends Thread {

	private DataOutputStream dataOutputStream;

	public NumberGeneration(PipedOutputStream pipedOutputStream) {
		this.dataOutputStream = new DataOutputStream(pipedOutputStream);
		start();
	}

	@Override
	public void run() {

		try {
			Random random = new Random();
			while (true) {
				double d = random.nextFloat() * 1000;
				System.out.println("random number generated - " + d);
				this.dataOutputStream.writeDouble(d);
				this.dataOutputStream.flush();
				threadSleep();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void threadSleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class RunningAverage extends Thread {

	private DataInputStream dataInputStream;

	public RunningAverage(PipedInputStream pipedInputStream) {
		this.dataInputStream = new DataInputStream(pipedInputStream);
		start();
	}

	@Override
	public void run() {
		byte[] b = new byte[1024];

		try {
			while (true) {
				double value = this.dataInputStream.readDouble();
				System.out.println(" --- " + value);
				threadSleep();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void threadSleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}