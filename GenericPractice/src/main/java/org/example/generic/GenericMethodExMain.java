package org.example.generic;

import java.util.ArrayList;

/**
 * This class demonstrates the use of the generic method `printList` from the `GenericMethodExample` class.
 * It shows how the method can handle lists of different types.
 */
public class GenericMethodExMain {
    public static void main(String[] args) {
        // Create a list of names (String type)
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("ABCD"); // Add name "ABCD"
        nameList.add("AOIAKS"); // Add name "AOIAKS"
        nameList.add("qweqwe"); // Add name "qweqwe"

        // Create a list of numbers (Integer type)
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(10); // Add number 10
        numberList.add(20); // Add number 20
        numberList.add(30); // Add number 30

        // Use the generic method to print the list of names
        GenericMethodExample.printList(nameList);

        // Use the generic method to print the list of numbers
        GenericMethodExample.printList(numberList);
    }
}
