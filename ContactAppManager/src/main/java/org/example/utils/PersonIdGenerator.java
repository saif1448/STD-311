package org.example.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PersonIdGenerator {
    private static final Random random = new Random();
    private static final Set<String> generatedIds = new HashSet<>();

    public static String generateUniqueId() {
        String id;
        do {
            int number = random.nextInt(1_000_000); // from 0 to 999999
            id = String.format("%06d", number);     // ensures it's 6 digits
        } while (generatedIds.contains(id));

        generatedIds.add(id);
        return id;
    }
}
