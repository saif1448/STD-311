package org.example.contactManagement;

import org.example.models.*;

import java.util.Scanner;

public class ContactFactory {
    private Scanner sc;

    public ContactFactory(Scanner sc) {
        this.sc = sc;
    }

    public Contact createContact(String name) {
        System.out.println("Select Contact Type: \n" +
                "1. Personal Contact \n" +
                "2. Business Contact \n" +
                "3. Emergency Contact \n" +
                "4. Social Media Contact");
        int contactType = Integer.parseInt(sc.nextLine());
        Contact newContact = null;
        switch (contactType) {
            case 1:
                newContact = createPersonalContact(name);
                break;
            case 2:
                newContact = createBusinessContact(name);
                break;
            case 3:
                newContact = createEmergencyContact(name);
                break;
            case 4:
                newContact = createSocialMediaContact(name);
                break;
            default:
                System.out.println("Invalid contact type.");
        }
        return newContact;
    }

    private PersonalContact createPersonalContact(String name) {
        System.out.println("Enter phone number:");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter email:");
        String email = sc.nextLine();
        System.out.println("Enter date of birth:");
        String dob = sc.nextLine();
        System.out.println("Enter address:");
        String address = sc.nextLine();

        return PersonalContact.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .dob(dob)
                .address(address)
                .contactCategory(ContactCategory.PERSONAL)
                .build();
    }

    private BusinessContact createBusinessContact(String name) {
        System.out.println("Enter phone number:");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter email:");
        String email = sc.nextLine();
        System.out.println("Enter business email:");
        String businessEmail = sc.nextLine();
        System.out.println("Enter business address:");
        String businessAddress = sc.nextLine();
        System.out.println("Enter business phone number:");
        String businessPhoneNumber = sc.nextLine();
        System.out.println("Enter company name:");
        String companyName = sc.nextLine();
        System.out.println("Enter business title:");
        String businessTitle = sc.nextLine();

        return BusinessContact.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .businessEmail(businessEmail)
                .businessAddress(businessAddress)
                .businessPhoneNumber(businessPhoneNumber)
                .companyName(companyName)
                .businessTitle(businessTitle)
                .contactCategory(ContactCategory.BUSINESS)
                .build();
    }

    private EmergencyContact createEmergencyContact(String name) {
        System.out.println("Enter phone number:");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter email:");
        String email = sc.nextLine();
        System.out.println("Enter relationship:");
        String relation = sc.nextLine();
        System.out.println("Enter priority level:");
        int priorityLevel = Integer.parseInt(sc.nextLine());
        System.out.println("Enter alternate phone number:");
        String alternatePhoneNumber = sc.nextLine();

        return EmergencyContact.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .relation(relation)
                .priorityLevel(priorityLevel)
                .alternativeNumber(alternatePhoneNumber)
                .contactCategory(ContactCategory.EMERGENCY)
                .build();
    }

    private SocialMediaContact createSocialMediaContact(String name) {
        System.out.println("Enter phone number:");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter email:");
        String email = sc.nextLine();
        System.out.println("Enter social media platform:");
        String socialMediaName = sc.nextLine();
        System.out.println("Enter handle name:");
        String handleName = sc.nextLine();

        return SocialMediaContact.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .socialMediaName(socialMediaName)
                .handleName(handleName)
                .contactCategory(ContactCategory.SOCIAL)
                .build();
    }
}