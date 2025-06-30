package org.example.contactManagement;

import org.example.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ContactManager {
    ContactManagerService contactManagerService = ContactManagerService.getInstance();
    Scanner sc;
    public ContactManager(Scanner sc) {
        this.sc = sc;
    }

    public <T extends Contact> void addContact(T newContact, String personName) {
        List<Person> person = contactManagerService.findByPersonName(personName);
        Person selectedPerson;
        if (person.size() > 1) {
            System.out.println("Select the Person to add Contact: ");
            System.out.println(person);
            int selectedPersonNumber = Integer.parseInt(sc.nextLine());
            selectedPerson = person.get(selectedPersonNumber - 1);
        } else {
            selectedPerson = person.getFirst();
        }
        contactManagerService.addContactDB(newContact, selectedPerson);
        System.out.println("The Contact has been added. ");
    }
//    public void showAllContacts() {
//        for (var contact : contactManagerService.getContactList().entrySet()) {
//            System.out.println(contact.getValue());
//        }
//    }
public void showAllContacts() {
    Map<String, ArrayList<Contact>> contactList = contactManagerService.getContactList();
    Map<String, String> personList = contactManagerService.getPersonList();

    if (contactList.isEmpty()) {
        System.out.println("No contacts found.");
        return;
    }

    // Header
    System.out.printf("%-10s | %-20s | %-20s | %-15s | %-30s | %-15s%n",
            "PersonID", "PersonName", "ContactName", "Phone", "Email", "Category");
    System.out.println("---------------------------------------------------------------------------------------------------------------");

    // Iterate through contacts
    for (Map.Entry<String, ArrayList<Contact>> entry : contactList.entrySet()) {
        String personId = entry.getKey();
        String personName = personList.getOrDefault(personId, "Unknown");
        ArrayList<Contact> contacts = entry.getValue();

        for (Contact contact : contacts) {
            String category = contact.getContactCategory() != null
                    ? contact.getContactCategory().name()
                    : "N/A";

            System.out.printf("%-10s | %-20s | %-20s | %-15s | %-30s | %-15s%n",
                    personId,
                    personName,
                    contact.getName(),
                    contact.getPhoneNumber(),
                    contact.getEmail(),
                    category);
        }
    }
}

    public void deletePerson(String personName) {
        List<Person> person = contactManagerService.findByPersonName(personName);
        Person selectedPerson;
        if (person.size() > 1) {
            System.out.println("Select the Person to delete Contact: ");
            System.out.println(person);
            int selectedPersonNumber = Integer.parseInt(sc.nextLine());
            selectedPerson = person.get(selectedPersonNumber - 1);
        } else {
            selectedPerson = person.getFirst();
        }
        contactManagerService.deleteAllContact(selectedPerson);
        System.out.println("The person has been deleted " + personName);

    }

    public void updateContact(String personName) {
       Contact contactTobeUpdated = new BusinessContact();

       contactTobeUpdated.updateContact(sc);
    }

}
