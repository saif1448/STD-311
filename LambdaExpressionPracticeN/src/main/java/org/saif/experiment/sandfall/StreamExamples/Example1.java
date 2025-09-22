package org.saif.experiment.sandfall.StreamExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Example1 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        System.out.println(list1.get(4));
        list1.set(4, 50);
        System.out.println(list1.get(4));
        list1.add(90);

        List<Integer> list2 = new ArrayList<>();
        for(var i : list1) {
            if(i % 2 == 0) {
                list2.add(i);
            }
        }
        System.out.println(list2);

        Function<List<Integer>, List<Integer>> evenListFilter = (list) -> {
            List<Integer> result = new ArrayList<>();
            for(var i : list) {
                if(i % 2 == 0) {
                    result.add(i);
                }
            }
            return result;
        };

        List<Integer> outputList = new ArrayList<>();

        List<Integer> list3 = new ArrayList<>(Arrays.asList(11,11,12,14,15,16,17,18,19,20));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(101,102,103,104,105,106,107,108,109,110));

        outputList = evenListFilter.apply(list3);
        System.out.println(outputList);
        outputList = evenListFilter.apply(list4);
        System.out.println(outputList);

        // Using Streams


        List<Integer> evenList = list4.stream().filter(val -> val%2 ==0).toList();
        System.out.println(evenList);

        System.out.println("------------list 3--------------");

        System.out.println(list3);

        //buggy code
//        for(int i = 0; i < list3.size(); i++) {
//            if(list3.get(i) % 2 != 0) {
//                list3.remove(list3.get(i));
//            }
//        }

        //good code
//        list3.removeIf(i -> i % 2 != 0);

        Iterator<Integer> iterator = list3.iterator();

        while(iterator.hasNext()) {
            Integer val = iterator.next();
            if(val % 2 != 0) {
                iterator.remove();
            }
        }

        System.out.println(list3);


    }
}
