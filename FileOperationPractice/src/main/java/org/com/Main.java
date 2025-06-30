package org.com;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

//        try(FileWriter writer = new FileWriter("TestFile.txt")){
//            writer.write("Hi! My Name is Saif Mahmud");
//            System.out.println("File created successfully");
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        try(FileReader fileReader = new FileReader("TestFile.txt")){
            int ch;
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}