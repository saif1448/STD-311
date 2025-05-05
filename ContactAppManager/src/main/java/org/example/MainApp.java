package org.example;

import org.example.models.Contact;
import org.example.models.PersonalContact;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainApp {
    public static void main(String[] args) {

        Contact personalContact = new PersonalContact();
        personalContact.setName("Adam Khan");
        System.out.println(personalContact);
    }
}