package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	private final static String senderEmail = "testEdy123@gmail.com";
	private final static String password = "123Qwer!";
	
	public static void sendRegisterEmail(String firstName, String lastName, String recieverEmail) {
		String host = "smtp.gmail.com"; // Sending email through gmail smtp
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, password);
			}
		});
		
		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recieverEmail));
			message.setSubject("Registered");
			message.setText(String.format("Thank you for your registration, %s %s", firstName, lastName));
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println(e);
		}
	}
	
}
