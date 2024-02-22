package org.caldeira.contact_list.controller.service;

import org.caldeira.contact_list.controller.model.Contact;

import java.util.List;

public interface IContactService {

    Contact addNewContact(Contact contact);

    Contact disableContact(Contact contact);

    List<Contact> getContactByName(String name);

    List<Contact> getContactByPhone(String phone);

    List<Contact> getContactByEMail(String eMail);
}
