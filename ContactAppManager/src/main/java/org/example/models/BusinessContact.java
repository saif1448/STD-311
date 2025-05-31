package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BusinessContact extends Contact{
    private String businessEmail;
    private String businessAddress;
    private String businessPhoneNumber;
    private String companyName;
    private String businessTitle;

    public BusinessContact(String name, String phoneNumber, String email, ContactCategory contactCategory, String businessEmail, String businessAddress, String businessPhoneNumber, String companyName, String businessTitle) {
        super(name, phoneNumber, email, contactCategory);
        this.businessEmail = businessEmail;
        this.businessAddress = businessAddress;
        this.businessPhoneNumber = businessPhoneNumber;
        this.companyName = companyName;
        this.businessTitle = businessTitle;
    }

    public BusinessContact(String businessEmail, String businessAddress, String businessPhoneNumber, String companyName, String businessTitle) {
        this.businessEmail = businessEmail;
        this.businessAddress = businessAddress;
        this.businessPhoneNumber = businessPhoneNumber;
        this.companyName = companyName;
        this.businessTitle = businessTitle;

        this.contactCategory = ContactCategory.BUSINESS;
    }
}
