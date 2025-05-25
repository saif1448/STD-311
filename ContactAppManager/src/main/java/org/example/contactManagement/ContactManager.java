package org.example.contactManagement;

import org.example.models.Contact;
import org.example.models.Person;

import java.util.List;
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
    }
    public void showAllContacts() {
        for (var contact : contactManagerService.getContactList().entrySet()) {
            System.out.println(contact.getValue());
        }
    }



}
