package com.patterns;

import com.patterns.contact.Contacts;
import com.patterns.directmail.DirectMail;

public class DirectMailXML extends DirectMail {

    private final String fileName;

    public DirectMailXML(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected Contacts createContacts() {
        return new ContactsXML(fileName);
    }
}
