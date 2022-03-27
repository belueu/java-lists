package dev.belueu.masterclass.challenge;

import java.util.ArrayList;

public class Phone {

    private String number;
    private ArrayList<Contact> contactList;

    public Phone(String number) {
        this.number = number;
        this.contactList = new ArrayList<>();
    }

    public Contact addNewContact(Contact contact) {
        Contact existingContact = findContact(contact.getName());
        if (existingContact != null) {
            return existingContact;
        }
        contactList.add(contact);
        return contact;
    }


    public Contact findContact(String name) {
        return contactList.stream().filter(contact -> name.equals(contact.getName())).findFirst().orElse(null);
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        Contact contactToUpdate = findContact(oldContact.getName());
        contactToUpdate.setName(newContact.getName());
        contactToUpdate.setPhone(newContact.getPhone());
    }

    public void listContacts() {
        contactList.forEach(contact -> System.out.println("Name: " + contact.getName() + ", Phone: " + contact.getPhone()));
    }

    public void removeContact(Contact contact) {
        Contact foundContact = findContact(contact.getName());
        contactList.remove(foundContact);
    }

    public String getContactDetails(Contact contact) {
        Contact foundContact = findContact(contact.getName());
        return "Details -> Name: " + foundContact.getName() + ", Phone: " + foundContact.getPhone();
    }
}
