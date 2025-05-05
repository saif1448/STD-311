package org.example.models;

public enum ContactCategory {

    PERSONAL("Personal contact, such as family and friends."),
    BUSINESS("Business contact, including clients, colleagues, or partners."),
    EMERGENCY("Emergency contact, like doctors or first responders."),
    SOCIAL("Social contact, met through online platforms or social groups.");

    private final String description;

    ContactCategory(String description) {
        this.description = description;
    }

}
