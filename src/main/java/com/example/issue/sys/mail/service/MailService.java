package com.example.issue.sys.mail.service;


import com.example.issue.sys.mail.vo.MailVo;


public interface MailService {


	public String sendMail(MailVo vo) throws Exception;

}
