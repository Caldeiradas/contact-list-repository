package org.caldeira.contact_list.controller.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
    private Long id;
    private String name;
    private String phoneNumber;
    private String eMail;
    private Boolean active = true;

    public Contact() {
    }

    public Contact(Long id, String name, String phoneNumber, String eMail, Boolean active) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.active = active;
    }

}
