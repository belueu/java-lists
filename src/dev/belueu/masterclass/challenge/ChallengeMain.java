package dev.belueu.masterclass.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChallengeMain {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Phone phone = new Phone("1232323123");

    public static void main(String[] args) throws IOException {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter Option Number: (6 -> List Options)\r");
            int option = Integer.parseInt(reader.readLine());

            switch (option) {
                case 0:
                    shutDown();
                    quit = true;
                    break;
                case 1:
                    listContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    showContact();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void shutDown() {
        System.out.println("Shutting down...");
    }

    private static void listContacts() {
        phone.listContacts();
    }

    private static void addNewContact() throws IOException {
        System.out.println("Enter new contact name: ");
        String contactName = reader.readLine();
        Contact foundContact = phone.findContact(contactName);
        if (foundContact != null) {
            System.out.println("Contact with Name: " + foundContact.getName() + " already exists");
        } else {
            System.out.println("Enter new contact phone: ");
            String contactPhone = reader.readLine();
            Contact newContact = Contact.creteContact(contactName, contactPhone);
            phone.addNewContact(newContact);
            System.out.println("Contact with Name: " + contactName + ", and Phone: " + contactPhone + " created!");
        }
    }

    private static void updateContact() throws IOException {
        System.out.println("Search contact by name: ");
        String contactName = reader.readLine();
        Contact foundContact = phone.findContact(contactName);
        if (foundContact == null) {
            System.out.println("Contact with Name: " + contactName + " not found");
        } else {
            System.out.println("Contact with Name: " + foundContact.getName() + " found");
            System.out.println("Please enter new Name: ");
            String newName = reader.readLine();
            if (phone.findContact(newName) != null) {
                System.out.println("Contact with Name: " + newName + " already exists");
            } else {
                System.out.println("Please enter new Phone: ");
                String newPhone = reader.readLine();
                Contact newContact = Contact.creteContact(newName, newPhone);
                System.out.println("Contact with Name: " + foundContact.getName() + ", and Phone: " + foundContact.getPhone());
                phone.updateContact(foundContact, newContact);
                System.out.println("updated to Name: " + newContact.getName() + ", and Phone: " + newContact.getPhone());
            }
        }
    }

    public static void removeContact() throws IOException {
        System.out.println("Search contact by name: ");
        String contactName = reader.readLine();
        Contact foundContact = phone.findContact(contactName);
        if (foundContact == null) {
            System.out.println("Contact with Name: " + contactName + " not found");
        } else {
            System.out.println("Contact with Name: " + foundContact.getName() + " found");
            phone.removeContact(foundContact);
            System.out.println("Contact with Name: " + foundContact.getName() + ", and Phone: " + foundContact.getPhone() + " removed");
        }

    }

    public static void showContact() throws IOException {
        System.out.println("Search contact by name: ");
        String contactName = reader.readLine();
        Contact foundContact = phone.findContact(contactName);
        if (foundContact == null) {
            System.out.println("Contact with Name: " + contactName + " not found");
        } else {
            System.out.println("Contact with Name: " + foundContact.getName() + " found");
            String contactDetails = phone.getContactDetails(foundContact);
            System.out.println(contactDetails);
        }
    }

    private static void printActions() {
        System.out.println("\nAvailable Option:");
        System.out.println("0 -> Shutdown");
        System.out.println("1 -> Show Contacts");
        System.out.println("2 -> Add Contact");
        System.out.println("3 -> Update Contact");
        System.out.println("4 -> Remove Contact");
        System.out.println("5 -> Contact Details");
        System.out.println("6 -> List Options");
        System.out.println("Choose option: ");
    }
}
