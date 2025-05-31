package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
@NoArgsConstructor
//@ToString(callSuper = true)
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
}
