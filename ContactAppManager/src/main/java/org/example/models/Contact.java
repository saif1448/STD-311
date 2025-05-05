package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Contact {
    protected String name;
    protected String phoneNumber;
    protected String email;
    protected ContactCategory contactCategory;
}
