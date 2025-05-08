package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(callSuper = true)
public class PersonalContact extends Contact{
    private String dob;
    private String address;

    @Override
    public String toString() {
        String output= "Name: " + name + " , " + "Phone Number: " + phoneNumber + " , " + "Email: " + email + " , " +
        " Contact Category: " + contactCategory + " , " + "DOB: " + dob + " , " + "Address: " + address;
        return output;
    }
}
