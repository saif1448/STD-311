package org.example.immutableClass;

public class ImmutableMainExample {
    public static void main(String[] args) {
        ImmutableClass i = new ImmutableClass("ABCD", "XYZ");

        System.out.println(i.name());

        ImmutableClass2 i2 = new ImmutableClass2("QWQW", "qase");
        i2.showTotalDescriptio();
    }
}
