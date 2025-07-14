package org.example.contactManagement;

import org.example.models.*;
import org.example.utils.ListVidualizer;

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
            ListVidualizer.printList(person);
            int selectedPersonNumber = Integer.parseInt(sc.nextLine());
            selectedPerson = person.get(selectedPersonNumber - 1);
        } else {
            selectedPerson = person.getFirst();
        }
        contactManagerService.addContactDB(newContact, selectedPerson);
        System.out.println("The Contact has been added. ");
    }

    public void showAllContacts() {
        Map<String, ArrayList<Contact>> contactList = contactManagerService.getContactList();
        Map<String, String> personList = contactManagerService.getPersonList();

        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        // Header
        System.out.printf("%-10s | %-20s | %-20s | %-15s | %-30s | %-15s | %-50s%n",
                "PersonID", "PersonName", "ContactName", "Phone", "Email", "Category", "Extra Info");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<String, ArrayList<Contact>> entry : contactList.entrySet()) {
            String personId = entry.getKey();
            String personName = personList.getOrDefault(personId, "Unknown");
            ArrayList<Contact> contacts = entry.getValue();

            for (Contact contact : contacts) {
                String category = contact.getContactCategory() != null
                        ? contact.getContactCategory().name()
                        : "N/A";

                // Determine extra info based on child class
                String extraInfo = "";
                if (contact instanceof BusinessContact) {
                    BusinessContact bc = (BusinessContact) contact;
                    extraInfo = "Company: " + bc.getCompanyName() + ", Title: " + bc.getBusinessTitle() +
                            ", Business Email: " + bc.getBusinessEmail() + ", Business Address: " + bc.getBusinessAddress() +
                            ", Business Phone: " + bc.getBusinessPhoneNumber();
                } else if (contact instanceof EmergencyContact) {
                    EmergencyContact ec = (EmergencyContact) contact;
                    extraInfo = "Relation: " + ec.getRelation() + ", Priority: " + ec.getPriorityLevel() +
                            ", Alternative Number: " + ec.getAlternativeNumber();
                } else if (contact instanceof SocialMediaContact) {
                    SocialMediaContact smc = (SocialMediaContact) contact;
                    extraInfo = "Platform: " + smc.getSocialMediaName() + ", Handle: " + smc.getHandleName();
                } else if (contact instanceof PersonalContact) {
                    PersonalContact pc = (PersonalContact) contact;
                    extraInfo = "DOB: " + pc.getDob() + ", Address: " + pc.getAddress();
                }

                System.out.printf("%-10s | %-20s | %-20s | %-15s | %-30s | %-15s | %-50s%n",
                        personId,
                        personName,
                        contact.getName(),
                        contact.getPhoneNumber(),
                        contact.getEmail(),
                        category,
                        extraInfo);
            }
        }
    }


    public void deletePerson(String personName) {
        List<Person> person = contactManagerService.findByPersonName(personName);
        Person selectedPerson;
        if (person.size() > 1) {
            System.out.println("Select the Person to delete Contact: ");
            ListVidualizer.printList(person);
            int selectedPersonNumber = Integer.parseInt(sc.nextLine());
            selectedPerson = person.get(selectedPersonNumber - 1);
        } else {
            selectedPerson = person.getFirst();
        }
        contactManagerService.deleteAllContact(selectedPerson);
        System.out.println("The person has been deleted " + personName);
    }

    public void deleteContact(String personName) {
        List<Person> person = contactManagerService.findByPersonName(personName);
        Person selectedPerson;
        if (person.size() > 1) {
            System.out.println("Select the Person to delete Contact: ");
            ListVidualizer.printList(person);
            int selectedPersonNumber = Integer.parseInt(sc.nextLine());
            selectedPerson = person.get(selectedPersonNumber - 1);
        } else {
            selectedPerson = person.getFirst();
        }
        System.out.println("Select the Contact to delete: ");
        ListVidualizer.printList(contactManagerService.getContactList().get(selectedPerson.getPersonId()));
        int selectedContactNumber = Integer.parseInt(sc.nextLine());
        contactManagerService.getContactList().get(selectedPerson.getPersonId()).remove(selectedContactNumber - 1);
        System.out.println("Selected Contact Number has been deleted.");
    }

    public void updateContact(String personName) {
        List<Person> person = contactManagerService.findByPersonName(personName);
        Person selectedPerson;
        if (person.size() > 1) {
            System.out.println("Select the Person to update Contact: ");
            ListVidualizer.printList(person);
            int selectedPersonNumber = Integer.parseInt(sc.nextLine());
            selectedPerson = person.get(selectedPersonNumber - 1);
        } else {
            selectedPerson = person.getFirst();
        }

        ArrayList<Contact> contacts = contactManagerService.getContactList().get(selectedPerson.getPersonId());
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("No contacts found for the selected person.");
            return;
        }

        System.out.println("Select the Contact to update: ");
        ListVidualizer.printList(contacts);
        int selectedContactNumber = Integer.parseInt(sc.nextLine());
        Contact contactToUpdate = contacts.get(selectedContactNumber - 1);
        contactToUpdate.updateContact(sc);

        System.out.println("The contact has been updated successfully.");
    }

}
