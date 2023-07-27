package com.example.mail;

import java.io.File;
import java.util.Properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Component
public class EmailSender 
{
	@Value("${file.path}")
	private String path;
	public void send(String subject,MultipartFile filename,String message)
	{
		final String username = "nitinvijaykar863@gmail.com";
		final String password = "kpdvqbflrgtqaudb";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			MimeMessage message1 = new MimeMessage(session);
			message1.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("rohitgabane1234@gmail.com"));
			message1.setSubject(subject);

			MimeBodyPart part1 = new MimeBodyPart();  
			String name=filename.getOriginalFilename();
			// making the full path
			String filePath=path+File.separator+name;
			DataSource source = new FileDataSource(filePath); 
			System.out.println("File Name is\t"+filePath);
			part1.setDataHandler(new DataHandler(source));  
			part1.setFileName(filePath);  
			
			BodyPart part2 = new MimeBodyPart();  
		    part2.setText(message);  
			
			Multipart multipart = new MimeMultipart();  
			multipart.addBodyPart(part1);
			multipart.addBodyPart(part2);
			
			message1.setContent(multipart);
			Transport.send(message1);
 
			System.out.println("Done completely");
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
