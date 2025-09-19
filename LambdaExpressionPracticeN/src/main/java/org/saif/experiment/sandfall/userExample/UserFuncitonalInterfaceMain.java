package org.saif.experiment.sandfall.userExample;

public class UserFuncitonalInterfaceMain {
    public static void main(String[] args) {

        User user = new User(1, "Saif mahmud paRvez", 30);
//        UserNameUpper userNameUpper = name -> name.toUpperCase();
        // Function Referencing
        UserNameUpper userNameUpper = String::toUpperCase;

        System.out.println("Upper Name " + userNameUpper.makeUpper(user.getName()));

        UserInterface userAddressUpper = u -> u.getName()+"123, ABC Square".toUpperCase();

        System.out.println("Upper Address " + userAddressUpper.makeUserAddressUpper(user));
    }
}
