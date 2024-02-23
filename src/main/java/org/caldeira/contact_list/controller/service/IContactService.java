package org.caldeira.contact_list.controller.service;

import org.caldeira.contact_list.controller.model.Contact;
import org.caldeira.contact_list.database.model.ContactDB;

import java.util.List;

public interface IContactService {

    Contact addNewContact(Contact contact);

    Contact disableContact(Contact contact);

    List<Contact> getAllContacts();

    List<Contact> getContactByName(String name);

    List<Contact> getContactByPhone(String phone);

    List<Contact> getContactFromEMail(String eMail);

    List<Contact> getContactFromName(String nextLine);

    List<Contact> contactDBListToContactList(List<ContactDB> contactDBList);
}
