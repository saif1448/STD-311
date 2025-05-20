package org.example;

import org.example.contactManagement.ContactManager;
import org.example.models.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainApp {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();

        Contact personalContact = new PersonalContact();
        personalContact.setName("Adam Khan");

        Contact businessContact = new BusinessContact();
        businessContact.setName("Adam Khan");

        Contact emergencyContact = new EmergencyContact();
        emergencyContact.setName("Adam Khan");

        Contact socialMediaContact = new SocialMediaContact();
        socialMediaContact.setName("Adam Khan");

        contactManager.addContact(personalContact);
        contactManager.addContact(businessContact);
        contactManager.addContact(emergencyContact);
        contactManager.addContact(socialMediaContact);

        contactManager.showAllContacts();

    }
}