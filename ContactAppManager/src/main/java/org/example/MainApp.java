package org.example;

import org.example.contactManagement.ContactFactory;
import org.example.contactManagement.ContactManager;
import org.example.models.Contact;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager contactManager = new ContactManager(sc);
        ContactFactory contactFactory = new ContactFactory(sc);
        boolean isAppRunning = true;

        while (isAppRunning) {
            System.out.println("1. Add Contact \n" +
                    "2. Show all Contacts \n" +
                    "3. Delete Contact Person \n" +
                    "4. Delete Contact \n" +
                    "5. Update Contact \n" +
                    "6. Exit Application");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Enter the Person Name:");
                    String personName = sc.nextLine();
                    Contact newContact = contactFactory.createContact(personName);
                    contactManager.addContact(newContact, personName);
                    break;
                case 2:
                    contactManager.showAllContacts();
                    break;
                case 3:
                    System.out.println("Enter the Person Name to delete:");
                    String personNameToDelete = sc.nextLine();
                    contactManager.deletePerson(personNameToDelete);
                    break;
                case 4:
                    System.out.println("Enter the Person Name to delete:");
                    personNameToDelete = sc.nextLine();
                    contactManager.deleteContact(personNameToDelete);
                    break;
                case 5:
                    System.out.println("Enter the Person Name to update:");
                    String personNameToUpdate = sc.nextLine();
                    contactManager.updateContact(personNameToUpdate);
                    break;
                case 6:
                    isAppRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, select a valid option.");
            }
        }
    }
}