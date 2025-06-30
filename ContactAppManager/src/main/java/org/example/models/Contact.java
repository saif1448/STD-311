package org.example.models;

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
public abstract class Contact {
    protected String name;
    protected String phoneNumber;
    protected String email;
    protected ContactCategory contactCategory;

    public abstract  void updateContact(Scanner sc);
}
