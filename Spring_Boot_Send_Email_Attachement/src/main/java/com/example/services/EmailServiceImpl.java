package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.mail.EmailSender;

@Service
public class EmailServiceImpl implements EmailService 
{
	@Autowired
	private EmailSender sender;

	@Override
	public void sendEmail(String subject,MultipartFile filename, String message) 
	{
		sender.send(subject,filename, message);
	}

}
