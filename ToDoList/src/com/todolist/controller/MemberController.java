package com.todolist.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.todolist.bean.MemberBean;
import com.todolist.model.Group;
import com.todolist.model.MailDetail;
import com.todolist.model.Member;
import com.todolist.service.GroupService;
import com.todolist.service.MailDetailService;
import com.todolist.service.MailService;
import com.todolist.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	MailDetailService mailDetailService;
	@Autowired
	SimpleMailMessage emailTemplate;
	
	@RequestMapping("viewMembers")
	public ModelAndView viewMembers(){
		ModelAndView model = new ModelAndView();
		
		model.addObject("allMembers", memberService.getAllMembers());
		int i =0;
		for(Group group: groupService.groupList()){
			i++;
			model.addObject("group"+i, group.getMember());
		}
		
		return model;
	}
	
	
	@RequestMapping(value = "addMember")
	public ModelAndView addMemberView(){
		return new ModelAndView("addMember","member",new MemberBean());
	}
	
	@RequestMapping(value = "saveMember", method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ModelAndView saveMember(@ModelAttribute("member")MemberBean memberBean,BindingResult result){
		
		memberService.saveMember(prepareMember(memberBean));
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping(value = "sendMessage")
	public ModelAndView sendMessageView(){
		return new ModelAndView("sendMail","mailDetails",new MailDetail());
	}
	
	@RequestMapping(value = "send", method = RequestMethod.POST)
	public ModelAndView send(@ModelAttribute("mailDetails")MailDetail mailDetail){
		mailDetailService.saveMailDetail(mailDetail);
		mailService.setEmailTemplate(prepareMessage(mailDetail));
		mailService.sendMail();
		return new ModelAndView("redirect:/sendMessage");
	}
	
	@RequestMapping(value="showProfile/{memberName}")
	public ModelAndView profile(@PathVariable(value="memberName")String name){
		
		return new ModelAndView("memberProfile");
	}
	
	public SimpleMailMessage prepareMessage(MailDetail mailDetail){
		emailTemplate.setSubject(mailDetail.getMailSubject());
		emailTemplate.setText(mailDetail.getMailMessage());
		emailTemplate.setTo(mailDetail.getMailTo());
		return emailTemplate;
	}
	
	public Member prepareMember(MemberBean memberBean){
		Member member = new Member();
		member.setEmail(memberBean.getEmail());
		member.setName(memberBean.getName());
		member.setPassword(memberBean.getPassword());
		member.setUsername(memberBean.getUsername());
		Blob blob = null;
		try {
		blob = new SerialBlob(memberBean.getImage().getBytes());
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
		member.setImage(blob);
		
		return member;
		
	}
}
