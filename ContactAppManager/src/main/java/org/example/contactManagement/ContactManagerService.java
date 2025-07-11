package org.example.contactManagement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;
import org.example.models.Contact;
import org.example.models.Person;
import org.example.utils.PersonIdGenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class ContactManagerService {
    private static ContactManagerService instance;
    private Map<String, ArrayList<Contact>> contactList = new HashMap<>();
    private Map<String, String> personList = new HashMap<>();

    private final String FILEPATH_CONTACT = "contacts.json";
    private final String FILEPATH_PERSON = "persons.json";
    private final ObjectMapper mapper;

    private ContactManagerService() {
        this.mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        personList = loadData(FILEPATH_PERSON, HashMap.class);
        contactList = loadData(FILEPATH_CONTACT, HashMap.class);
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

    private  <T extends HashMap<?, ?>> T loadData(String filePath, Class<T> type) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                return type.getDeclaredConstructor().newInstance();
            }
            return mapper.readValue(file, new TypeReference<T>() {});
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading data from file: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creating instance of type: " + type.getName());
        }

        return null;
    }

    public List<Person> findByPersonName(String personName) {
        personName = personName.toLowerCase();
        List<Person> selectedPersonList = new ArrayList<>();
        for (var person : personList.entrySet()) {
            String name = person.getValue().toLowerCase();
            if (name.contains(personName)) {
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
