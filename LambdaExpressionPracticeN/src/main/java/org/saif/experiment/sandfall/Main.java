package org.saif.experiment.sandfall;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        SayHelloImpl sayHelloImpl = new SayHelloImpl();
//        SayHelloImpl2 sayHelloImpl2 = new SayHelloImpl2();
//        printSayHello(sayHelloImpl);
//        printSayHello(sayHelloImpl2);
//
//        SayHelloInterface sayHelloInterface = new SayHelloInterface() {
//            @Override
//            public void sayHello() {
//                System.out.println("Saying Hello from Anonymous Class");
//            }
//        };
//
        printSayHello(() -> System.out.println("Saying Hello from Lambda "));

        printSayHello(() -> System.out.println("ASMKJASJAS"));

        printName((s) -> System.out.println("Hi there from  " + s), "Saif" );

        doIntegerOperation((a,b) -> a + b, 10, 20);
        doIntegerOperation((a, b) -> a*b, 20, 30);

    }


    private static void printSayHello(SayHelloInterface sayHello) {
        sayHello.sayHello();
    }

    private static void printName(SayNameInterface sayName, String name){
        sayName.sayName(name);
    }

    private static void doIntegerOperation(IntegerOperation integerOperation, int a, int b){
       int result = integerOperation.operate(a,b);
        System.out.println("Result is : " + result);
    }
}