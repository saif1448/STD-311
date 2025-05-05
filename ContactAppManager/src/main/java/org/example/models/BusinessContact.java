package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BusinessContact extends Contact{
    private String businessEmail;
    private String businessAddress;
    private String businessPhoneNumber;
    private String companyName;
    private String businessTitle;
}
