import com.patterns.DirectMailCSV;
import com.patterns.directmail.DirectMail;

import javax.swing.*;

public class ClientRelationshipCSV {

    public static void main(String[] args) {
        DirectMail directMail = new DirectMailCSV("contacts.csv");

        String message = JOptionPane.showInputDialog(null, "Digite a mensagem de e-mail:");
        boolean status = directMail.sendEmail(message);

        JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);
    }
}
