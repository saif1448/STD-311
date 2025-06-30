package org.example.contactManagement;

import org.example.models.*;
import java.util.Scanner;

public class ContactFactory {
    private final Scanner scanner;

    public ContactFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    public Contact createContact() {
        System.out.println("Select Contact Type:");
        System.out.println("1. Personal Contact");
        System.out.println("2. Business Contact");
        System.out.println("3. Emergency Contact");
        System.out.println("4. Social Media Contact");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter contact name:");
        String name = scanner.nextLine();

        System.out.println("Enter contact number:");
        String number = scanner.nextLine();

        return switch (choice) {
            case 1 -> createPersonalContact(name, number);
            case 2 -> createBusinessContact(name, number);
            case 3 -> createEmergencyContact(name, number);
            case 4 -> createSocialMediaContact(name, number);
            default -> throw new IllegalArgumentException("Invalid contact type");
        };
    }

    private PersonalContact createPersonalContact(String name, String number) {
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter date of birth:");
        String dob = scanner.nextLine();

        System.out.println("Enter address:");
        String address = scanner.nextLine();

        PersonalContact contact = PersonalContact.builder()
                .name(name)
                .phoneNumber(number)
                .email(email)
                .contactCategory(ContactCategory.PERSONAL)
                .dob(dob)
                .address(address)
                .build();

        return contact;
    }

    private BusinessContact createBusinessContact(String name, String number) {
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter business email:");
        String businessEmail = scanner.nextLine();

        System.out.println("Enter business address:");
        String businessAddress = scanner.nextLine();

        System.out.println("Enter business phone number:");
        String businessPhoneNumber = scanner.nextLine();

        System.out.println("Enter company name:");
        String companyName = scanner.nextLine();

        System.out.println("Enter business title:");
        String businessTitle = scanner.nextLine();

        BusinessContact contact = BusinessContact.builder()
                .name(name)
                .phoneNumber(number)
                .email(email)
                .contactCategory(ContactCategory.BUSINESS)
                .businessEmail(businessEmail)
                .businessAddress(businessAddress)
                .businessPhoneNumber(businessPhoneNumber)
                .companyName(companyName)
                .businessTitle(businessTitle)
                .build();

        return contact;
    }

    private EmergencyContact createEmergencyContact(String name, String number) {
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter relation (e.g., Father, Friend, Neighbor):");
        String relation = scanner.nextLine();

        System.out.println("Enter priority level (1 for highest priority, 2 for secondary):");
        int priorityLevel = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter alternative number:");
        String alternativeNumber = scanner.nextLine();

        EmergencyContact contact = EmergencyContact.builder()
                .name(name)
                .phoneNumber(number)
                .email(email)
                .contactCategory(ContactCategory.EMERGENCY)
                .relation(relation)
                .priorityLevel(priorityLevel)
                .alternativeNumber(alternativeNumber)
                .build();

        return contact;
    }

    private SocialMediaContact createSocialMediaContact(String name, String number) {
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter social media name (e.g., Twitter, Instagram, LinkedIn):");
        String socialMediaName = scanner.nextLine();

        System.out.println("Enter handle name:");
        String handleName = scanner.nextLine();

        SocialMediaContact contact = SocialMediaContact.builder()
                .name(name)
                .phoneNumber(number)
                .email(email)
                .contactCategory(ContactCategory.SOCIAL)
                .socialMediaName(socialMediaName)
                .handleName(handleName)
                .build();

        return contact;
    }
}
