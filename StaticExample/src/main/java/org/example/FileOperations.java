package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {

    public static void readFile(String fileName) {
        try(BufferedReader input = Files.newBufferedReader(Paths.get(fileName))) {

            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
