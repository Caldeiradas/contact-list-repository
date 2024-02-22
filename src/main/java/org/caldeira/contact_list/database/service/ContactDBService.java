package org.caldeira.contact_list.database.service;

import org.caldeira.contact_list.database.model.ContactDB;
import org.caldeira.contact_list.database.repository.ContactDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDBService {
    @Autowired
    private ContactDBRepository repository;

    public List<ContactDB> findByName(String name) {
        return this.repository.findByNameOrderByNameAsc(name);
    }

    public List<ContactDB> findByEMail(String eMail) {
        return this.repository.findByeMailOrderByNameAsc(eMail);
    }

    public List<ContactDB> findByPhoneNumber(String phoneNumber) {
        return this.repository.findByNameOrderByNameAsc(phoneNumber);
    }

    public ContactDB save(ContactDB contactDB) {
        return this.repository.save(contactDB);
    }

    /**
     * Delete by inactivation for history purposes
     *
     * @param contactDB
     * @return
     */
    public ContactDB deactivate(ContactDB contactDB) {
        contactDB.setActive(false);
        return this.repository.save(contactDB);
    }
}
