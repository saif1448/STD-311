package org.example.contactManagement;

import org.example.models.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactManagerService {
    private Map<String, ArrayList<Contact>> contactList = new HashMap<>();

    public <T extends Contact> void addContact(T contact) {
        String name = contact.getName();

        if (!contactList.containsKey(name)) {
            contactList.put(name, new ArrayList<>());
        }
        contactList.get(name).add(contact);
    }
}
