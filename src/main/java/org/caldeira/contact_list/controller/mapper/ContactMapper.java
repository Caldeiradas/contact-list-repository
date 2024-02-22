package org.caldeira.contact_list.controller.mapper;

import org.caldeira.contact_list.controller.model.Contact;
import org.caldeira.contact_list.database.model.ContactDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactMapper {

    public Contact getContact(final ContactDB contactDB) {
        return new Contact(
                contactDB.getId(),
                contactDB.getName(),
                contactDB.getPhoneNumber(),
                contactDB.geteMail(),
                contactDB.getActive()
        );
    }

    public List<Contact> getContacts(final List<ContactDB> contactDBList) {
        return contactDBList.stream().map(this::getContact).collect(Collectors.toList());
    }

    public ContactDB getContactDB(final Contact contact) {
        return new ContactDB(
                contact.getId(),
                contact.getName(),
                contact.getPhoneNumber(),
                contact.geteMail(),
                contact.getActive()
        );
    }

    public List<ContactDB> getContactDBs(final List<Contact> contactList){
        return contactList.stream().map(this::getContactDB).collect(Collectors.toList());
    }


}
