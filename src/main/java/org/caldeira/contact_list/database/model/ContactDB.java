package org.caldeira.contact_list.database.model;

import jakarta.persistence.*;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
