package org.example.immutableClass;

public class ImmutableMainExample {
    public static void main(String[] args) {
//        ImmutableClass i = new ImmutableClass("ABCD", "XYZ");
//
//        System.out.println(i.name());
//
//        ImmutableClass2 i2 = new ImmutableClass2("QWQW", "qase");
//        i2.showTotalDescriptio();

        ImmutableClass3 i3 = new ImmutableClass3("IUOQW", 13);
        ImmutableClass4 i4 = new ImmutableClass4("QWQW", 15);

        System.out.println(i3.getName());
        System.out.println(i3.getAge());

        System.out.println(i4.name());
        System.out.println(i4.age());

        i3.showDetails();
        i4.showDetails();

        System.out.println(i3);
        System.out.println(i4);
    }
}
