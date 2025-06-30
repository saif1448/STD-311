package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class SocialMediaContact extends Contact {
    private String socialMediaName; // e.g., "Twitter", "Instagram", "LinkedIn"
    private String handleName;

    public SocialMediaContact(String name, String phoneNumber, String email, ContactCategory contactCategory,
            String socialMediaName, String handleName) {
        super(name, phoneNumber, email, contactCategory);
        this.socialMediaName = socialMediaName;
        this.handleName = handleName;
    }

    public SocialMediaContact(String socialMediaName, String handleName) {
        this.socialMediaName = socialMediaName;
        this.handleName = handleName;
        this.contactCategory = ContactCategory.SOCIAL;
    }
}
