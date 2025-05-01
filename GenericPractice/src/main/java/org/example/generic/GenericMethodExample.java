package org.example.generic;

import java.util.ArrayList;

/**
 * This class demonstrates the use of a generic method in Java.
 * Generic methods allow you to write a method that can operate on objects of various types.
 */
public class GenericMethodExample {

    /**
     * A generic method that prints all elements of a given list.
     * 
     * @param <T>      The type of elements in the list.
     * @param itemList The list of items to be printed.
     */
    public static <T> void printList(ArrayList<T> itemList) {
        // Iterate through each item in the list and print it
        for (var item : itemList) {
            System.out.println(item); // Print the current item
        }
    }

}
