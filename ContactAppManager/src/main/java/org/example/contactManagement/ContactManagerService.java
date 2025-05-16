package org.example.contactManagement;

import lombok.Getter;
import org.example.models.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class ContactManagerService {
    private static ContactManagerService instance;
    private Map<String, ArrayList<Contact>> contactList = new HashMap<>();

    private ContactManagerService() {
    }

    public static ContactManagerService getInstance() {
        if (instance == null) {
            instance = new ContactManagerService();
        }
        return instance;
    }

    public <T extends Contact> void addContactDB(T contact) {
        String name = contact.getName();

        if (!contactList.containsKey(name)) {
            contactList.put(name, new ArrayList<>());
        }
        contactList.get(name).add(contact);
    }
}
