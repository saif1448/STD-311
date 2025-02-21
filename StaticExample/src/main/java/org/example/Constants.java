package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class Constants {

    //constants
    public  final String file_name1;
    public  final String file_name2;

    Dotenv dotenv = Dotenv.load();

    public Constants(){
        this.file_name1 = dotenv.get("FILE_NAME_1");
        this.file_name2 = dotenv.get("FILE_NAME_2");
    }

    public String getFile_name1() {
        return file_name1;
    }

    public String getFile_name2() {
        return file_name2;
    }
}
