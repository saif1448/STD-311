package org.saif.experiment.sandfall.userExample;

import java.util.Arrays;
import java.util.Comparator;

public class UserWithLambdaMain {
    public static void main(String[] args) {
        User[] users = {
                new User(10, "Alice", 30),
                new User(5,  "Bob",   25),
                new User(7,  "Alice", 25),
                new User(9,  "alice", 30),
                new User(12, "Zoe",   25)
        };

        /* --- natural order (still uses Comparable) --- */
        Arrays.sort(users);
        System.out.println("Natural order (age asc, then name asc):");
        printArray(users);
        System.out.println("--------------------------");

        /* --- natural order (still uses Comparable) --- */
        Arrays.sort(users, UserDemoWithLambda.BY_NAME);
        printArray(users);
        System.out.println("--------------------------");

        /* --- lambda comparator: id desc --- */
        Arrays.sort(users, UserDemoWithLambda.BY_ID_DESC);
        printArray(users);
        System.out.println("--------------------------");

        /* --- lambda comparator: age asc, then name asc --- */
        Arrays.sort(users, UserDemoWithLambda.BY_AGE_THEN_NAME);
        printArray(users);
        System.out.println("--------------------------");

        /* --- inline lambda comparator: name length desc --- */
        System.out.println("\nBy age then name (desc) – inline lambda + method ref:");
        Arrays.sort(users, Comparator.comparing(User::getName, String.CASE_INSENSITIVE_ORDER).reversed());
        printArray(users);
        System.out.println("--------------------------");
    }

    private static void printArray(User[] arr) {
        for (User u : arr) {
            System.out.println(u);
        }
    }
}
