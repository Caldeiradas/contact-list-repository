package org.caldeira.contact_list.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Contact")
public class ContactDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private String phoneNumber;
    private String eMail;
    private Boolean active = true;

    public ContactDB() {}

    public ContactDB(Long id, String name, String phoneNumber, String eMail, Boolean active) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.active = active;
    }

}
