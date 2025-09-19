package org.saif.experiment.sandfall.FunctionalInterfacePractice;

import java.util.function.*;

public class FunctionalInterfaceMain {

    public static void main(String[] args) {

//        StringManipulator toUpperCase = s -> {
//            return s.toUpperCase();
//        };
//        StringManipulator toLowerCase = s -> {
//            return s.toLowerCase();
//        };
//
//        String output = toUpperCase.apply("aBc");
//        System.out.println(output);
//        output = toLowerCase.apply("ABC");
//        System.out.println(output);

//        Function<String, String> toUpper = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.toUpperCase();
//            }
//        };

//        Function<String, String> toUpper = s -> s.toUpperCase();

        Function<String, String> toUpper = String::toUpperCase;

        String output = toUpper.apply("Hello");
        System.out.println(output);

        System.out.println("-------------------------------------------");

        /* --------------------------------------------------------
         * 2.  Predicate<T>  – built-in
         * ------------------------------------------------------ */

        Predicate<Integer> isEvenWithoutLambda = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };

        System.out.println(isEvenWithoutLambda.test(20));
        System.out.println(isEvenWithoutLambda.test(43));

        Predicate<Integer> isEvenWithLambda = i -> i % 2 == 0;

        System.out.println(isEvenWithLambda.test(20));
        System.out.println(isEvenWithLambda.test(43));


        System.out.println("-------------------------------------------");

        /* --------------------------------------------------------
         * 3.  Consumer<T>  – built-in
         * ------------------------------------------------------ */

        Consumer<String> sayHelloWithoutLambda = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Saying Hello From: "+ s);
            }
        };
        sayHelloWithoutLambda.accept("Saif");

        Consumer<String> sayHelloWithLambda = s -> System.out.println("Saying Hello From: "+ s);
        sayHelloWithLambda.accept("ABC");

        System.out.println("-------------------------------------------");

        /* --------------------------------------------------------
         * 4.  Supplier<T>  – built-in
         * ------------------------------------------------------ */
        Supplier<Double> randolWithoutLambda = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };

        System.out.println(randolWithoutLambda.get());

        Supplier<Double> randolWithLambda = Math::random;

        System.out.println(randolWithLambda.get());


        System.out.println("-------------------------------------------");



    }

}
