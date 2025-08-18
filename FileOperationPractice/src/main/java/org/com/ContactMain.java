package org.com;

public class ContactMain {
    public static void main(String[] args) {
        Contact contact1 = new Contact("John Doe", "123-456-7890");
        Contact contact2 = new Contact("ABCD Doe", "456-789-7890");
        Contact contact3 = new Contact("John Doe", "123-456-7890");

        ContactService contactService = new ContactService();

        contactService.addContact("1", contact1);
        contactService.addContact("1", contact3);
        contactService.addContact("2", contact2);

        contactService.showContact();

    }
}
