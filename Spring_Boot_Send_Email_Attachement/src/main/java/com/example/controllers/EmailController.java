package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.services.EmailService;

@RestController
public class EmailController 
{
	@Autowired
	private EmailService service;
	
	@PostMapping("/email")
	public void sendEmail(@RequestParam("subject")String subject,@RequestParam("file")MultipartFile filename,@RequestParam("message")String message)
	{
		service.sendEmail(subject, filename, message);
	}
}
