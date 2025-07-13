package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@Data
@NoArgsConstructor
@SuperBuilder
public class PersonalContact extends Contact{
    private String dob;
    private String address;

    public PersonalContact(String name, String phoneNumber, String email, ContactCategory contactCategory, String dob, String address) {
        super(name, phoneNumber, email, contactCategory);
        this.dob = dob;
        this.address = address;
    }

    public PersonalContact(String dob, String address) {
        this.dob = dob;
        this.address = address;
        this.contactCategory = ContactCategory.PERSONAL;
    }

    @Override
    public String toString() {
        String output= "Name: " + name + " , " + "Phone Number: " + phoneNumber + " , " + "Email: " + email + " , " +
        " Contact Category: " + contactCategory + " , " + "DOB: " + dob + " , " + "Address: " + address;
        return output;
    }

    @Override
    public void updateContact(Scanner sc) {
        System.out.println("Updating Personal Contact...");

        System.out.print("Enter contact name (leave blank to keep current): ");
        String input = sc.nextLine();
        if (!input.isEmpty()) this.name = input;

        System.out.print("Enter phone number: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.phoneNumber = input;

        System.out.print("Enter email: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.email = input;

        System.out.print("Enter date of birth (DOB): ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.dob = input;

        System.out.print("Enter address: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.address = input;
    }
}
