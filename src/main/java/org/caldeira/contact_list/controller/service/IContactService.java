package org.caldeira.contact_list.controller.service;

import org.caldeira.contact_list.controller.model.Contact;

public interface IContactService {

    Contact addNewContact(Contact contact);

    Contact disableContact(Contact contact);
}
