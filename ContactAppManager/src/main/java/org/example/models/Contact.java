package org.example.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BusinessContact.class, name = "BusinessContact"),
        @JsonSubTypes.Type(value = PersonalContact.class, name = "PersonalContact"),
        @JsonSubTypes.Type(value = EmergencyContact.class, name = "EmergencyContact"),
        @JsonSubTypes.Type(value = SocialMediaContact.class, name = "SocialMediaContact"),
})
public abstract class Contact {
    protected String name;
    protected String phoneNumber;
    protected String email;
    protected ContactCategory contactCategory;

    public abstract void updateContact(Scanner sc);
}
