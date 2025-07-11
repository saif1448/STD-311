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
public class EmergencyContact extends Contact{
    private String relation;            // e.g., "Father", "Friend", "Neighbor"
    private int priorityLevel;          // e.g., 1 for highest priority, 2 for secondary
    private String alternativeNumber;

    public EmergencyContact(String name, String phoneNumber, String email, ContactCategory contactCategory,
                            String relation, int priorityLevel, String alternativeNumber) {
        super(name, phoneNumber, email, contactCategory);
        this.relation = relation;
        this.priorityLevel = priorityLevel;
        this.alternativeNumber = alternativeNumber;
    }

    public EmergencyContact(String relation, int priorityLevel, String alternativeNumber) {
        this.relation = relation;
        this.priorityLevel = priorityLevel;
        this.alternativeNumber = alternativeNumber;

        this.contactCategory = ContactCategory.EMERGENCY;
    }

    @Override
    public void updateContact(Scanner sc) {
        System.out.println("Updating Emergency Contact...");

        System.out.print("Enter contact name (leave blank to keep current): ");
        String input = sc.nextLine();
        if (!input.isEmpty()) this.name = input;

        System.out.print("Enter phone number: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.phoneNumber = input;

        System.out.print("Enter email: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.email = input;

        System.out.print("Enter relation: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.relation = input;

        System.out.print("Enter priority level: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.priorityLevel = Integer.parseInt(input);

        System.out.print("Enter alternative number: ");
        input = sc.nextLine();
        if (!input.isEmpty()) this.alternativeNumber = input;
    }
}
