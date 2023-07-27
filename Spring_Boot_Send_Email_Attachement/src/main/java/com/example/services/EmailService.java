package com.example.services;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService 
{
	void sendEmail(String subject,MultipartFile filename,String message);
}
