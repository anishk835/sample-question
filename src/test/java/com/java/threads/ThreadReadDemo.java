package com.java.threads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.*;
public class ThreadReadDemo {

    /**
     * Java multithreaded reading large files
     * 
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new MultiThread(), "A");
        Thread t2 = new Thread(new MultiThread(), "B");
        //t1.start();
        //t2.start();
        
        System.out.println("\n\nParallel word count example using Old Testement King James bible");
        textWordCount("kjvdat.txt");
    }

    private static void textWordCount(String fileName) throws Exception {
        long start = Instant.now().toEpochMilli();
        ConcurrentHashMap<String, LongAdder> wordCounts = new ConcurrentHashMap<>();
        System.out.println("\tReading file: "+fileName);
        Path filePath = Paths.get(fileName);
        Files.readAllLines(filePath)
            .parallelStream()                               // Start streaming the lines
            .map(line -> line.split("\\s+"))                // Split line into individual words
            .flatMap(Arrays::stream)                        // Convert stream of String[] to stream of String
            .parallel()                                     // Convert to parallel stream
            .filter(w -> w.matches("\\w+"))                 // Filter out non-word items
            .map(String::toLowerCase)                       // Convert to lower case
            .forEach(word -> {                              // Use an AtomicAdder to tally word counts
                if (!wordCounts.containsKey(word))          // If a hashmap entry for the word doesn't exist yet
                    wordCounts.put(word, new LongAdder());  // Create a new LongAdder
                wordCounts.get(word).increment();           // Increment the LongAdder for each instance of a word
            });
        wordCounts
                .keySet()
                .stream()
                .map(key -> String.format("%-10d %s", wordCounts.get(key).intValue(), key))
                .sorted((prev, next) -> compare(parseInt(next.split("\\s+")[0]), parseInt(prev.split("\\s+")[0])))
                .limit(5)
                .forEach(t -> System.out.println("\t"+t));
        long end = Instant.now().toEpochMilli();
        System.out.println(String.format("\tCompleted in %d milliseconds", (end-start)));
    }
}

class MultiThread implements Runnable {
    private static BufferedReader br = null;
    private List<String> list;

    static {
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\anishk\\Desktop\\Nokia\\sftpd\\home\\test\\moved\\Group1_1089254_357.csv"), 10);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        String line = null;
        int count = 0;
        while (true) {
            // System.out.println(Thread.currentThread().getName());
            this.list = new ArrayList<String>();
            synchronized (br) {
                String thread_name = Thread.currentThread().getName();
                try {
                    while ((line = br.readLine()) != null) {
                        if (count < 15) {
                            list.add(thread_name + " - " + line);
                            count++;
                        } else {
                            list.add(thread_name + " - " + line);
                            count = 0;
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1);
                display(this.list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (line == null)
                break;
        }

    }

    public void display(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println(list.size());
    }

}
