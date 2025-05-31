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
                    "3. Delete Contact Person \n" +
                    "4. Exit Application" );
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    Contact personalContact = new PersonalContact("01/01/1999", "123 Street");
                    contactManager.addContact(personalContact, "Kelly");
                    Contact personalContact2 = new BusinessContact("k@g.com", "123 Street",
                            "123","Abc company", "Manager");
                    contactManager.addContact(personalContact2, "Kelly");

                    Contact personalContact3 = new PersonalContact("01/01/1999", "123 Street");
                    contactManager.addContact(personalContact3, "Dan");
                    Contact personalContact4 = new BusinessContact("k@g.com", "123 Street",
                            "123","Abc company", "Analyst");
                    contactManager.addContact(personalContact4, "Dan");
                    break;
                case 2:
                    contactManager.showAllContacts();
                    break;
                case 3:
                    System.out.println("Enter the Person Name to delete: ");
                    String personName = sc.nextLine();
                    contactManager.deletePerson(personName);
                    break;
                case 4:
                    isAppRunning = false;
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Invalid option, select a option from above");
            }

        }


    }
}