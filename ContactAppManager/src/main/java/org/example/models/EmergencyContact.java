package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmergencyContact extends Contact{
    private String relation;            // e.g., "Father", "Friend", "Neighbor"
    private int priorityLevel;          // e.g., 1 for highest priority, 2 for secondary
    private String alternativeNumber;

    public EmergencyContact(String name, String phoneNumber, String email, ContactCategory contactCategory, String relation, int priorityLevel, String alternativeNumber) {
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
}
