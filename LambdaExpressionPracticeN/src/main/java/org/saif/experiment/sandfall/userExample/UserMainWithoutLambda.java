package org.saif.experiment.sandfall.userExample;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class UserMainWithoutLambda {
    public static void main(String[] args) {
        User[] users = {
                new User(10, "Alice", 30),
                new User(5,  "Bob",   25),
                new User(7,  "Alice", 25),   // same age, different name
                new User(9,  "alice", 30),   // same age as first, different case
                new User(12, "Zoe",   25)
        };

        // Natural Order (age, then name)
        Arrays.sort(users);
        System.out.println("Natural order (age asc, then name asc):");
        printArray(users);


        // alternative order : name only
        Arrays.sort(users, User.BY_NAME);
        System.out.println("\nOrder by name (name asc):");
        printArray(users);

        // alternative order : id only, desc
        Arrays.sort(users, User.BY_ID_DESC);
        System.out.println("\nOrder by id (id desc):");
        printArray(users);


        // alternative order : age only, desc
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.getAge(), o1.getAge());
            }
        }
        );
        System.out.println("\nOrder by age (age desc):");
        printArray(users);


    }

    private static void printArray(User[] arr) {
        for (User u : arr) {
            System.out.println(u);
        }
    }
}
