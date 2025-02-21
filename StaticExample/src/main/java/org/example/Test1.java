package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test1 {

    public void readFile(){
        System.out.println("Reading from Test 1");
        Constants constants = new Constants();
        FileOperations.readFile(constants.getFile_name1());
    }

}
