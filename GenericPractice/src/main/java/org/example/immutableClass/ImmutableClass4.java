package org.example.immutableClass;


import java.io.Serializable;

public record ImmutableClass4(String name, int age){
    @Override
    public String toString() {
        return name + " - " + age;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
