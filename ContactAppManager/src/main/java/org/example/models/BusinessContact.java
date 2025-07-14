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
public class BusinessContact extends Contact{
    private String businessEmail;
    private String businessAddress;
    private String businessPhoneNumber;
    private String companyName;
    private String businessTitle;

    public BusinessContact(String name, String phoneNumber, String email, ContactCategory contactCategory,
                           String businessEmail, String businessAddress, String businessPhoneNumber,
                           String companyName, String businessTitle) {
        super(name, phoneNumber, email, contactCategory);
        this.businessEmail = businessEmail;
        this.businessAddress = businessAddress;
        this.businessPhoneNumber = businessPhoneNumber;
        this.companyName = companyName;
        this.businessTitle = businessTitle;
    }

    public BusinessContact(String businessEmail, String businessAddress, String businessPhoneNumber,
                           String companyName, String businessTitle) {
        this.businessEmail = businessEmail;
        this.businessAddress = businessAddress;
        this.businessPhoneNumber = businessPhoneNumber;
        this.companyName = companyName;
        this.businessTitle = businessTitle;

        this.contactCategory = ContactCategory.BUSINESS;
    }

    @Override
    public void updateContact(Scanner sc) {

        System.out.println("Updating Business Contact...");

        System.out.print("Enter contact name (leave blank to keep current): ");
        String input = sc.nextLine();
        if (!input.isEmpty()) this.name = input;

        System.out.print("Enter phone number: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.phoneNumber = input;

        System.out.print("Enter email: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.email = input;

        System.out.print("Enter business email: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.businessEmail = input;

        System.out.print("Enter business address: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.businessAddress = input;

        System.out.print("Enter business phone number: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.businessPhoneNumber = input;

        System.out.print("Enter company name: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.companyName = input;

        System.out.print("Enter business title: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.businessTitle = input;



    }
}
