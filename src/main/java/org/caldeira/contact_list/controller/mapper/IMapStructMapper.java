package org.caldeira.contact_list.controller.mapper;

import org.caldeira.contact_list.controller.model.Contact;
import org.caldeira.contact_list.database.model.ContactDB;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IMapStructMapper {
    Contact contactDBToContact(ContactDB contactDB);

    ContactDB contactToContactDB(Contact contact);
}
/*
{

    public Contact getContact(final ContactDB contactDB) {
        return new Contact(
                contactDB.getId(),
                contactDB.getName(),
                contactDB.getPhoneNumber(),
                contactDB.getEMail(),
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
                contact.getEMail(),
                contact.getActive()
        );
    }

    public List<ContactDB> getContactDBs(final List<Contact> contactList){
        return contactList.stream().map(this::getContactDB).collect(Collectors.toList());
    }
}
 */