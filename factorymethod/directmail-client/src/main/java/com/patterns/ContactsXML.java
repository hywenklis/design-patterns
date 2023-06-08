package com.patterns;

import com.patterns.contact.Contact;
import com.patterns.contact.Contacts;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.List;

public class ContactsXML implements Contacts {

    private final String fileName;

    public ContactsXML(String fileName) {
        this.fileName = fileName;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> all() {
        XStream xStream = new XStream();
        xStream.alias("contacts", List.class);
        xStream.alias("contact", Contact.class);

        URL file = this.getClass().getResource("/" + fileName);
        return (List<Contact>) xStream.fromXML(file);
    }
}
