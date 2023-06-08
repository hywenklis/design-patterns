package com.patters.contact;

import au.com.bytecode.opencsv.CSVReader;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Contacts {
    public List<Contact> retrieveCSVContacts(String fileName) {
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

    @SuppressWarnings("unchecked")
    public List<Contact> retrieveXMLContacts(String fileName) {
        XStream xStream = new XStream();
        xStream.alias("contacts", List.class);
        xStream.alias("contact", Contact.class);

        URL file = this.getClass().getResource("/" + fileName);
        return (List<Contact>) xStream.fromXML(file);
    }

}
