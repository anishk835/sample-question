package com.java.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;

public class MultiThreadedFileReading {

    public static void main(String[] args) {

        File file = new File("");
        long fileSize = file.length();

        int totalThreadCount = 2;

        Thread[] thread = new Thread[totalThreadCount];
        
        List<Thread> list = Arrays.asList(thread);
        
        for (int i = 0; i < thread.length; i++) {
            //int size = (int) Math.ceil(fileSize * 1.0 / threads);
        }

        FileReaderThread fileReaderThread;

        try {
            RandomAccessFile rf = new RandomAccessFile("rtest.dat", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < totalThreadCount; i++) {
            fileReaderThread = new FileReaderThread();
            thread[i] = fileReaderThread;
        }        

        for (int i = 0; i < thread.length; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class FileReaderThread extends Thread {

    public FileReaderThread() {
        start();
    }

    @Override
    public void run() {
        super.run();
    }
}

class FileInfo {
    long start, end;

    public FileInfo(long start, long end) {
        this.start = start;
        this.end = end;
    }
}