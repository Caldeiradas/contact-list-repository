package org.caldeira.contact_list.controller.mapper;

import org.caldeira.contact_list.controller.model.Contact;
import org.caldeira.contact_list.database.model.ContactDB;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IMapStructMapper {
    Contact contactDBToContact(ContactDB contactDB);

    ContactDB contactToContactDB(Contact contact);
}