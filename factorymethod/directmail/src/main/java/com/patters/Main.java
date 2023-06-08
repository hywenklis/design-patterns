package com.patters;

import com.patters.directmail.DirectMail;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        DirectMail directMail = new DirectMail();
        String message = JOptionPane.showInputDialog(null, "Informe a mensagem para o e-mail");

        boolean status = directMail.sendEmail("contacts.csv", message);
        System.out.println(status);
    }
}