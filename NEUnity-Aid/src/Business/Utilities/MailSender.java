/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Utilities;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


/**
 *
 * @author tarunangrish
 */
public class MailSender {
    
    public static void sendEmailMessage(String emailId, String sub, String text) throws UnsupportedEncodingException {
        String to = emailId;
        
        String from="neunityaid@gmail.com";
        String fromname="NEUnity-Aid";
        String SMTP_USERNAME  = "neunityaid@gmail.com";
        String pass = "22J@N1998";
        String subject=sub;

        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.ssl.protocols","TLSv1.2");
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from,fromname));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            //message.setContent(BODY,"text/html");
            message.setText(text);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, SMTP_USERNAME, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid email id");
        }
    }
    
}
