package org.example.contactManagement;

import lombok.Getter;
import org.example.models.Contact;
import org.example.models.Person;
import org.example.utils.PersonIdGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class ContactManagerService {
    private static ContactManagerService instance;
    private Map<String, ArrayList<Contact>> contactList = new HashMap<>();
    private Map<String, String> personList = new HashMap<>();

    private ContactManagerService() {
    }

    public static ContactManagerService getInstance() {
        if (instance == null) {
            instance = new ContactManagerService();
        }
        return instance;
    }

    public <T extends Contact> void addContactDB(T contact, Person person) {
        String personId = person.getPersonId();

        if (!contactList.containsKey(personId)) {
            contactList.put(personId, new ArrayList<>());
            personList.put(personId, person.getPersonName());
        }
        contactList.get(personId).add(contact);
    }

    public List<Person> findByPersonName(String personName) {
        List<Person> selectedPersonList = new ArrayList<>();
        for (var person : personList.entrySet()) {
            if (personName.equals(person.getValue())) {
                Person p = Person.builder()
                        .personId(person.getKey())
                        .personName(person.getValue())
                        .build();
                selectedPersonList.add(p);
            }
        }
        if (selectedPersonList.size() < 1) {
            Person p = Person.builder()
                    .personId(PersonIdGenerator.generateUniqueId())
                    .personName(personName)
                    .build();
            selectedPersonList.add(p);
            personList.put(p.getPersonId(), p.getPersonName());
        }
        return selectedPersonList;
    }

    public void deleteAllContact(Person person) {
        String personId = person.getPersonId();
        personList.remove(personId);
        contactList.remove(personId);
    }
}
