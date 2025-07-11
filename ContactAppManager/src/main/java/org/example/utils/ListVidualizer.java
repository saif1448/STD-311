package org.example.utils;

import java.util.List;

public class ListVidualizer {
    public static void printList(List<?> objectList) {
        for (int i = 0; i < objectList.size(); i++) {
            System.out.println((i + 1) + ". " + objectList.get(i));
        }
    }
}
