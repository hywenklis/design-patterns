import com.patterns.DirectMailXML;
import com.patterns.directmail.DirectMail;

import javax.swing.*;

public class ClientRelationshipXML {

    public static void main(String[] args) {
        DirectMail directMail = new DirectMailXML("contacts.xml");

        String message = JOptionPane.showInputDialog(null, "Informe a mensagem para o novo cliente");
        boolean status = directMail.sendEmail(message);

        JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);
    }
}
