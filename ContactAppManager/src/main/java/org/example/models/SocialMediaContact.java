package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@Data
@NoArgsConstructor
@ToString
@SuperBuilder
public class SocialMediaContact extends Contact{
    private String socialMediaName;  // e.g., "Twitter", "Instagram", "LinkedIn"
    private String handleName;

    public SocialMediaContact(String name, String phoneNumber, String email, ContactCategory contactCategory,
                              String socialMediaName, String handleName) {
        super(name, phoneNumber, email, contactCategory);
        this.socialMediaName = socialMediaName;
        this.handleName = handleName;
    }

    public SocialMediaContact(String socialMediaName, String handleName) {
        this.socialMediaName = socialMediaName;
        this.handleName = handleName;
        this.contactCategory = ContactCategory.SOCIAL;
    }

    @Override
    public void updateContact(Scanner sc) {
        System.out.println("Updating Social Media Contact...");

        System.out.print("Enter contact name (leave blank to keep current): ");
        String input = sc.nextLine();
        if (!input.isEmpty()) this.name = input;

        System.out.print("Enter phone number: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.phoneNumber = input;

        System.out.print("Enter email: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.email = input;

        System.out.print("Enter social media name: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.socialMediaName = input;

        System.out.print("Enter handle name: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.handleName = input;
    }
}
