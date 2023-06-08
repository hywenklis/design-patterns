package com.patters.directmail;

import com.patters.contact.Contact;
import com.patters.contact.Contacts;

import java.util.List;


public class DirectMail {
    public boolean sendEmail(String fileName, String message) {
        Contacts contactsRepository = new Contacts();
        List<Contact> contacts = contactsRepository.retrieveCSVContacts(fileName);

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
