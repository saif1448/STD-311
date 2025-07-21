package org.com;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactRepository {

    private final String FILE_PATH = "contacts.json";
    private HashMap<String, ArrayList<Contact>> contactList;
    private final ObjectMapper mapper;

    public ContactRepository() {
        this.mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        contactList = loadContacts();
    }

    private HashMap<String, ArrayList<Contact>> loadContacts() {
        File contactFile = new File(FILE_PATH);
        if(!contactFile.exists()){
            return new HashMap<>();
        }
        try {
            return mapper.readValue(contactFile, new TypeReference<HashMap<String, ArrayList<Contact>>>(){});
        }catch (IOException e){
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void saveContacts() {
       try{
           mapper
                   .writerWithDefaultPrettyPrinter()
                   .writeValue(new File(FILE_PATH), contactList);
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    public HashMap<String, ArrayList<Contact>> getContactList() {
        return contactList;
    }

    public void addContact(String personId, Contact contact) {
        if (!contactList.containsKey(personId)) {
            contactList.put(personId, new ArrayList<>());
        }
        contactList.get(personId).add(contact);
        saveContacts();
    }


}
