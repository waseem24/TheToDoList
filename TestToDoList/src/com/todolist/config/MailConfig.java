package com.todolist.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages={"com.todolist"})
public class MailConfig {

	@Bean
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		javaMailSender.setUsername("reminder.todolist9@gmail.com");
		javaMailSender.setPassword("i9i8u8i7u8u8ii9i8u8i7iuy");

		javaMailSender.setJavaMailProperties(getMailProperties());

		return javaMailSender;
	}

	@Bean
	public SimpleMailMessage emailTemplate(){
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("reminder.todolist9@gmail.com");
		return simpleMailMessage;
	}
	
	private Properties getMailProperties() {
		 Properties props = new Properties();
	        props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); //SMTP Host
	        props.put("mail.smtp.starttls.enable", "true"); //SSL Port
	        props.put("mail.smtp.auth","true");
		return props;
	}

}
