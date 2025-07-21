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
        personList = loadPersonData(FILEPATH_PERSON);
        contactList = loadContactData(FILEPATH_CONTACT);
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

    private HashMap<String, String> loadPersonData(String filePath) {

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return new HashMap<>();
            }
            return mapper.readValue(file, new TypeReference<HashMap<String, String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    private HashMap< String, ArrayList<Contact>> loadContactData(String filePath) {

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return new HashMap<>();
            }
            return mapper.readValue(file, new TypeReference<HashMap<String, ArrayList<Contact>>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void saveData() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILEPATH_PERSON), personList);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILEPATH_CONTACT), contactList);
            System.out.println("Data is saved in Database");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
