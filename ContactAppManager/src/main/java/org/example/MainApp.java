package org.example;

import org.example.contactManagement.ContactFactory;
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
                    "4. Update Contact \n" +
                    "5. Exit Application");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Enter person name to add contact for:");
                    String personName = sc.nextLine();
                    ContactFactory contactFactory = new ContactFactory(sc);
                    Contact contact = contactFactory.createContact();
                    contactManager.addContact(contact, personName);
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    contactManager.showAllContacts();
                    break;
                case 3:
                    System.out.println("Enter the Person Name to delete: ");
                    personName = sc.nextLine();
                    contactManager.deletePerson(personName);
                    break;
                case 4:
                    System.out.println("Enter the Person Name to delete: ");
                    personName = sc.nextLine();
                    contactManager.updateContact(personName);
                case 5:
                    isAppRunning = false;
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Invalid option, select a option from above");
            }

        }

    }
}