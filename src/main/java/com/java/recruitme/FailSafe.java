package com.java.recruitme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe {

    public static void main(String args[]) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 });
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer no = (Integer) itr.next();
            System.out.println(no);

            if (no == 8)
                // itr.remove();
                // This will not print,
                // hence it has created separate copy
                list.add(14);

        }
        System.out.println(list);

        List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        ListIterator<Integer> listIterator = al.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next() == 2) {
                listIterator.remove();
                
                //listIterator.set(101);
                listIterator.add(100);

                if (listIterator.hasPrevious())
                    listIterator.previous();
            }
        }

        System.out.println("print al after adding 100 - " + al);
        Iterator<Integer> itr1 = al.iterator();
        while (itr1.hasNext()) {
            if (itr1.next() == 100) {
                // will not throw Exception
                itr1.remove();
            }
        }
        System.out.println("print al after removng 100 - " + al);

        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        Iterator iterator = cityCode.keySet().iterator();

        while (iterator.hasNext()) {
            String key = cityCode.get(iterator.next());

            // adding an element to Map
            // exception will be thrown on next call
            // of next() method.
            if (key.equals("Russia")) {
                iterator.remove();
            }
            // cityCode.put("Istanbul", "Turkey");
        }

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);

        // Getting an Iterator from map
        Iterator it = map.keySet().iterator();

        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key + " : " + map.get(key));

            // This will reflect in iterator.
            // Hence, it has not created separate copy
            if (key.equals("THREE"))
                it.remove();
            map.put("SEVEN", 7);
        }

        System.out.println("print concurrent hashmap - " + map);
    }
}
