package org.example.immutableClass;

public record ImmutableClass2(String val1, String val2) {

    public void showTotalDescriptio(){
        System.out.println("val " + val1 + " 2" +val2);

        //DTO ----> Data Transfer Object
    }

}
