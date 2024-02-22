package org.caldeira.contact_list.controller.service;


import org.caldeira.contact_list.controller.mapper.ContactMapper;
import org.caldeira.contact_list.controller.model.Contact;
import org.caldeira.contact_list.database.model.ContactDB;
import org.caldeira.contact_list.database.service.ContactDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private ContactDBService contactDBService;

    @Override
    public Contact addNewContact(Contact contact) {
        ContactDB contactDB = this.contactMapper.getContactDB(contact);
        this.contactDBService.save(contactDB);
        return this.contactMapper.getContact(contactDB);
    }

    @Override
    public Contact disableContact(Contact contact) {
        ContactDB contactDB = this.contactMapper.getContactDB(contact);
        this.contactDBService.deactivate(contactDB);
        return this.contactMapper.getContact(contactDB);
    }

    public List<Contact> getContactByName (String name){
        List<ContactDB> contactDBList = this.contactDBService.findByName(name);
        return contactMapper.getContacts(contactDBList);
    }

    public
}
