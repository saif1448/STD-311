package org.com;

import java.io.*;

public class BufferredExample {
    public static void main(String[] args) {
        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter("TestFile.txt")
        )
        ){
            writer.write("Hello World! New Lines");
        }catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("TestFile.txt")
        )){
            String line = bufferedReader.readLine();
            System.out.println(line);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
