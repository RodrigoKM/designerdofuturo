package com.designerdofuturo.bean;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class Mail {
	private String smtpHost;
	private int smtpPort;
	private String username;
	private String password;
	private Session session;
	
	public Mail(String smtpHost, int smtpPort, String username, String password) {
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
		this.username = username;
		this.password = password;
		setSession();
	}
	
	public boolean sendMail(String[] recipients, String subject, String text, byte[] textfiles, String filename) {
		try {
			Address[] addresses = new Address[recipients.length];
			Message msg = new MimeMessage(session);
			Multipart content = new MimeMultipart();
			BodyPart part;
			
			for (int i = 0; i < recipients.length; i++)
				addresses[i] = new InternetAddress(recipients[i]);
			msg.setFrom(new InternetAddress(username));
			for (Address address: addresses)
				msg.addRecipient(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			
			if (text != null) {
				part = new MimeBodyPart();
				part.setText(text);
				content.addBodyPart(part);
			}
			
			if (textfiles != null && textfiles.length > 0) {
				part = new MimeBodyPart();
				DataSource ds = new ByteArrayDataSource(textfiles, "text/plain");
				part.setDataHandler(new DataHandler(ds));
				part.setFileName(filename);
				content.addBodyPart(part);
			}
			
			msg.setContent(content);
			System.out.println("Sending message...");
			Transport.send(msg, addresses);
			System.out.println("Message sent.");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void setSession() {
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", String.valueOf(smtpPort));
		props.put("mail.smtp.auth", "true");
		Authenticator auth = new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		session = Session.getDefaultInstance(props, auth);
	}
}