package org.example.contactManagement;

import org.example.models.Contact;

public class ContactManager<T extends Contact> {
    ContactManagerService contactManagerService = ContactManagerService.getInstance();

    public void addContact(T newContact) {
        contactManagerService.addContactDB(newContact);
    }
    public void showAllContacts() {
        for (var contact : contactManagerService.getContactList().entrySet()) {
            System.out.println(contact.getValue());
        }
    }



}
