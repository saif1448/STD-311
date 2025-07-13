package org.com;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService() {
        this.contactRepository = new ContactRepository();
    }

    public void addContact(String personId, Contact contact) {
        contactRepository.addContact(personId, contact);
    }

    public void showContact(){
        HashMap<String, ArrayList<Contact>> contactList = contactRepository.getContactList();
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (String personId : contactList.keySet()) {
            System.out.println("Person ID: " + personId);
            ArrayList<Contact> contacts = contactList.get(personId);
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

}
