package org.caldeira.contact_list;

import jakarta.annotation.PostConstruct;
import org.caldeira.contact_list.view.ContactTextInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactListApplication {
    @Autowired
    private ContactTextInterface textInterface;
    public static void main(String[] args) {
        SpringApplication.run(ContactListApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        this.textInterface.init();
    }

}
