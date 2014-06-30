package com.todolist.service.impl;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.todolist.model.Task;
import com.todolist.service.MailService;
import com.todolist.service.TaskService;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	private SimpleMailMessage emailTemplate;

	@Autowired
	private JavaMailSenderImpl javaMailSender;
	
	@Autowired
	private TaskService taskService;

	public void setEmailTemplate(SimpleMailMessage emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail() {

		String fromEmail = emailTemplate.getFrom();
		String[] toEmail = emailTemplate.getTo();
		String emailSubject = emailTemplate.getSubject();
		String emailBody = emailTemplate.getText();

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

			helper.setFrom(fromEmail);
			helper.setTo(toEmail);
			helper.setSubject(emailSubject);
			helper.setText(emailBody);

			/*
			  uncomment the following lines for attachment FileSystemResource
			  file = new FileSystemResource("attachment.jpg");
			  helper.addAttachment(file.getFilename(), file);
			 */

			javaMailSender.send(mimeMessage);
			System.out.println("Mail sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	
	
	}

	@Scheduled(fixedRate = 300000)
	@Override
	public void sendMailToMember() {
		Date currentDate = new Date();
		List<Task> taskList = taskService.taskList(); 
		
		for (Task task: taskList)
		{
			long currentTime =task.getFinishTime().getMinutes() - currentDate.getMinutes();
			long newDate = task.getFinishTime().getDay()- currentDate.getDay();
			
			if(currentTime > 0 && currentTime <=5 && task.getIsDone() == false && newDate ==0)
			{
				System.out.println("Send mail to " + task.getMember().getEmail());
				//invoke sendMail method here.
			}
			else {
				System.out.println("Don't send email !!!");
			}
		}
		
	}

}
