package org.caldeira.contact_list.database.repository;

import org.caldeira.contact_list.database.model.ContactDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactDBRepository extends JpaRepository<ContactDB, Long> {

    List<ContactDB> findByNameOrderByNameAsc(String name);

    List<ContactDB> findByeMailContainsOrderByNameAsc(String eMail);

    List<ContactDB> findByPhoneNumberContainsOrderByNameAsc(String phoneNumber);

    List<ContactDB> findByNameContainsOrderByNameAsc(String name);
}
