package com.naoset.framework.business.notification.email;

import com.terralcode.framework.domain.notification.email.Email;
import java.util.Properties;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Ezequiel
 */
@Stateless
@LocalBean
public class EmailService {

    @Asynchronous
    public void send(Email email)
    {       
        // Sender's email ID needs to be mentioned
//        String from = "notificaciones.crm@naoset.com";//change accordingly
//        final String username = "notificaciones.crm@naoset.com";//change accordingly
//        final String password = "n0t1f1cac10nes#";//change accordingly
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "false");
//        props.put("mail.smtp.host",  "smtp.1and1.es");
//        props.put("mail.smtp.port", "587");
//
//        // Get the Session object.
//        Session session = Session.getInstance(
//                props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication()
//                    {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//            // Create a default MimeMessage object.
//            Message message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.setRecipients(Message.RecipientType.TO,
//                                  InternetAddress.parse(email.getTo()));
//
//            // Set Subject: header field
//            message.setSubject(email.getSubject());
//
//            // Now set the actual message
//            message.setText(email.getMessage());
//
//            // Send message
//            Transport.send(message);
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
    }
}
