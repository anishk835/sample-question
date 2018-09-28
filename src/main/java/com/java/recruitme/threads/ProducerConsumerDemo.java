package com.java.recruitme.threads;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        new Consumer(producer).start();
    }
}

class Consumer extends Thread {

    Producer producer;

    public Consumer(Producer p) {
        this.producer = p;
    }

    @Override
    public void run() {
        while (true) {
            Integer res = this.producer.getConsumeValue();
            System.out.println(" value of integer in the consumer - " + res);
            try {
                sleep( 2000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {

    static final int MAX_QUEUE = 5;
    AtomicInteger atomicInteger = new AtomicInteger(0);
    private Vector<Integer> vector = new Vector<>();

    @Override
    public void run() {
        while (true) {
            produceMessage();
            /*
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
        }
    }

    private synchronized void produceMessage() {
        if (MAX_QUEUE == vector.size()) {
            try {
                System.out.println("just befor calling wait cheching the size - " + vector.size());
                wait();
                System.out.println("wait is called....in the producred");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("before adding element from producer");
        vector.addElement(atomicInteger.incrementAndGet());
        //System.out.println("after adding element from producer");
        notify();
        //System.out.println("called notify ....... from producer");
    }

    public synchronized Integer getConsumeValue() {
        Integer val = null;
        notify();
        //synchronized (vector) {
            if (vector.size() == 0) {
                try {
                    wait();
                    System.out.println("waiting after consumeing all the element from vector");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            val = vector.firstElement();
            vector.remove(val);
        //}
        return val;
    }
}