package com.todolist.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public interface MailService {

	public void setEmailTemplate(SimpleMailMessage emailTemplate);
	public void setJavaMailSender(JavaMailSenderImpl javaMailSender);
	public void sendMail();
}
