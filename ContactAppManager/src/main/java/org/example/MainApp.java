package org.example;

import org.example.contactManagement.ContactManager;
import org.example.models.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager contactManager = new ContactManager(sc);
        boolean isAppRunning = true;

        while (isAppRunning) {
            System.out.println("1. Add Contact \n" +
                    "2. Show all Contact \n" +
                    "3. Exit Application" );
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    Contact personalContact = new PersonalContact("01/01/1999", "123 Street");
                    contactManager.addContact(personalContact, "Kelly");
                    break;
                case 2:
                    contactManager.showAllContacts();
                    break;
                case 3:
                    isAppRunning = false;
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Invalid option, select a option from above");
            }

        }


    }
}