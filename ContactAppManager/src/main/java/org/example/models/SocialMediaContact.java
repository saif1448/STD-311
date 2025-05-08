package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SocialMediaContact extends Contact{
    private String socialMediaName;  // e.g., "Twitter", "Instagram", "LinkedIn"
    private String handleName;
}
