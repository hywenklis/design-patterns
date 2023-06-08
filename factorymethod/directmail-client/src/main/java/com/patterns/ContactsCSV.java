package com.patterns;

import au.com.bytecode.opencsv.CSVReader;
import com.patterns.contact.Contact;
import com.patterns.contact.Contacts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactsCSV implements Contacts {

    private final String fileName;

    public ContactsCSV(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Contact> all() {
        List<Contact> contacts = new ArrayList<>();
        CSVReader csvReader = null;

        try {
            URI uri = Objects.requireNonNull(this.getClass().getResource("/" + fileName)).toURI();
            File fileCSV = new File(uri);
            FileReader fileReader = new FileReader(fileCSV);
            csvReader = new CSVReader(fileReader);
            String [] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contacts.add(new Contact(nextLine[0].trim(), nextLine[1].trim()));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro lendo arquivo csv", e);
        } finally {
            try {
                assert csvReader != null;
                csvReader.close();
            } catch (IOException ignored) {}
        }
        return contacts;
    }
}
