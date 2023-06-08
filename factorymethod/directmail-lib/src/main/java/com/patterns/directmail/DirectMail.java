package com.patterns.directmail;

import com.patterns.contact.Contact;
import com.patterns.contact.Contacts;

import java.util.List;

public abstract class DirectMail {

    protected abstract Contacts createContacts();

    public boolean sendEmail(String message) {

        List<Contact> contacts = createContacts().all();

        System.out.println("Conectando no servidor SMTP...");
        System.out.println("Mensagem a ser enviada" + message);
        System.out.println();

        for (Contact contact : contacts) {
            System.out.println("From: <contact@patterns.com>");
            System.out.printf("To: [%s] <%s>\n", contact.getName(), contact.getEmail());
            System.out.println(message);
            System.out.println();
        }

        return true;
    }
}
