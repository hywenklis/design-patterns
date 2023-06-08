package com.patterns;

import com.patterns.contact.Contacts;
import com.patterns.directmail.DirectMail;

public class DirectMailCSV extends DirectMail {

    private final String fileName;

    public DirectMailCSV(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected Contacts createContacts() {
        return new ContactsCSV(fileName);
    }
}
