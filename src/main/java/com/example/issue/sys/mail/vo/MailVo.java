package com.example.issue.sys.mail.vo;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class MailVo {	 

	  private String sendName;
	  private String sendEmail;
	  private String sendMessage;
	  
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getSendEmail() {
		return sendEmail;
	}
	public void setSendEmail(String sendEmail) {
		this.sendEmail = sendEmail;
	}
	public String getSendMessage() {
		return sendMessage;
	}
	public void setSendMessage(String sendMessage) {
		this.sendMessage = sendMessage;
	}
	  

}
