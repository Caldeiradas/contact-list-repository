package org.caldeira.contact_list.controller.service;

import org.caldeira.contact_list.controller.mapper.IMapStructMapper;
import org.caldeira.contact_list.controller.model.Contact;
import org.caldeira.contact_list.database.model.ContactDB;
import org.caldeira.contact_list.database.service.ContactDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService implements IContactService {
    @Autowired
    private IMapStructMapper mapper;
    @Autowired
    private ContactDBService contactDBService;

    @Override
    public Contact addNewContact(Contact contact) {
        ContactDB contactDB = this.mapper.contactToContactDB(contact);
        this.contactDBService.save(contactDB);
        return this.mapper.contactDBToContact(contactDB);
    }

    @Override
    public Contact disableContact(Contact contact) {
        ContactDB contactDB = this.mapper.contactToContactDB(contact);
        this.contactDBService.deactivate(contactDB);
        return this.mapper.contactDBToContact(contactDB);
    }

    @Override
    public List<Contact> getAllContacts(){
        return this.contactDBListToContactList(this.contactDBService.findAll());
    }

    @Override
    public List<Contact> getContactByName (String name){
        List<ContactDB> contactDBList = this.contactDBService.findByName(name);
        return this.contactDBListToContactList(contactDBList);
    }

    @Override
    public List<Contact> getContactFromName (String name){
        List<ContactDB> contactDBList = this.contactDBService.findFromName(name);
        return this.contactDBListToContactList(contactDBList);
    }

    @Override
    public List<Contact> getContactByPhone(String phone){
        List<ContactDB> contactDBList = this.contactDBService.findByPhoneNumber(phone);
        return this.contactDBListToContactList(contactDBList);
    }

    @Override
    public List<Contact> getContactFromEMail(String eMail){
        List<ContactDB> contactDBList= this.contactDBService.findFromEMail(eMail);
        return this.contactDBListToContactList(contactDBList);
    }

    @Override
    public List<Contact> contactDBListToContactList(List<ContactDB> contactDBList){
        return contactDBList.stream().map(cdb -> this.mapper.contactDBToContact(cdb)).collect(Collectors.toList());
    }
}
