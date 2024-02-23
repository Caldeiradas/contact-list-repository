package org.caldeira.contact_list.view;

import org.caldeira.contact_list.controller.model.Contact;
import org.caldeira.contact_list.controller.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ContactTextInterface {
    @Autowired
    private IContactService contactService;

    public void init() {
        this.mainMenu();
    }

    private void mainMenu() {
        Scanner scan = new Scanner(System.in);
        boolean validOption;
        while (true) {
            System.out.println("What do you pretend? (please choose one of the option below)\n" +
                "1. Add Contact\n" +
                "2. Search Contact\n" +
                "3. Close the program");
            do {
                String input = scan.next();
                validOption = true;
                switch (input) {
                    case "1" -> addContact();
                    case "2" -> searchContact();
                    case "3" -> {
                        System.out.println("Good bye!");
                        return;
                    }
                    default -> {
                        invalidOption(input, 2);
                        validOption = false;
                    }
                }
            } while (!validOption);
        }
    }

    private void searchContact() {

    }

    private void addContact() {
        Contact contact = new Contact();
        this.fillContact(contact);
        this.validateContact(contact);
        this.confirmContact(contact);
    }

    private void fillContact(Contact contact) {
        contact.setName(this.getContactName());
        contact.setPhoneNumber(this.getContactPhoneNumber());
        contact.setEMail(this.getContactEMail());
    }


    private void validateContact(Contact contact) {
        if (contact.getPhoneNumber().isEmpty() && contact.getEMail().isEmpty()) {
            System.out.println("Both phone number and e-mail are empty. At least one must be filled.\n" +
                    "1. Fill phone number\n" +
                    "2. Fill e-mail\n" +
                    "3. Fill both");
            Scanner scan = new Scanner(System.in);
            boolean validOption;
            do {
                String input = scan.next();
                validOption = true;
                switch (input) {
                    case "1" -> contact.setPhoneNumber(this.getContactPhoneNumber());
                    case "2" -> contact.setEMail(this.getContactEMail());
                    case "3" -> {
                        contact.setPhoneNumber(this.getContactPhoneNumber());
                        contact.setEMail(this.getContactEMail());
                    }
                    default -> {
                        invalidOption(input, 3);
                        validOption = false;
                    }
                }
            } while (!validOption);
        }
    }

    private String getContactName() {
        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("Desired Contact name? (Minimum of 3 characters)");
        name = scan.nextLine().replaceAll("\\s+", " ").trim(); //remove space before word
        System.out.println(name);
        if (name.length() < 3) {
            System.out.println("Name mas be at lease 3 character long and cannot start with spacing");
            name = this.getContactName();
        }
        return name;
    }

    private String getContactPhoneNumber() {
        String phoneNumber;
        Scanner scan = new Scanner(System.in);
        System.out.println("Desired Contact phone number? (With country code)");
        phoneNumber = scan.nextLine().replaceAll("[^0-9+*#]", "");
        System.out.println(phoneNumber);
        if (!phoneNumber.isEmpty()
                && (phoneNumber.length() < 3 || phoneNumber.length() > 6)
                && !phoneNumber.matches("^\\+(?:[0-9]?){6,14}[0-9]$")) {
            System.out.printf("Phone number is invalid: [%s]%n", phoneNumber);
            phoneNumber = this.getContactPhoneNumber();
        }
        return phoneNumber;
    }

    private String getContactEMail() {
        String eMail;
        Scanner scan = new Scanner(System.in);

        System.out.println("Desired Contact e-mail?");
        eMail = scan.nextLine().replaceAll("\\s", "").toLowerCase();
        System.out.println(eMail);
        if (!eMail.isEmpty() && !eMail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            System.out.printf("E-mail is invalid: [%s]%n", eMail);
            eMail = this.getContactEMail();
        }

        return eMail;
    }

    private void confirmContact(Contact contact) {
        System.out.println("Is this correct? [Y/N]");
        System.out.println(this.formattedContact(contact));
        Scanner scan = new Scanner(System.in);

        String input = scan.next().toUpperCase();
        switch (input) {
            case "Y" -> {
                System.out.println("Contact information has been saved");
                this.contactService.addNewContact(contact);
            }
            case "N" -> {
                System.out.println("Please fill Contact information again!");
                this.addContact();
            }
            default -> {
                System.out.println("invalid option. Please choose another option.");
                this.confirmContact(contact);
            }
        }

    }

    private String formattedContact(Contact contact) {
        return String.format(
                "Name:              [%s]\n" +
                        "Phone Number:      [%s]\n" +
                        "E-Mail Address:    [%s]",
                contact.getName(), contact.getPhoneNumber(), contact.getEMail()
        );

    }

    private void invalidOption(String input, int lastOption) {
        System.out.printf("Invalid option: [%s]. Valid option are between [1] and [%s]%n", input, lastOption);
    }
}
