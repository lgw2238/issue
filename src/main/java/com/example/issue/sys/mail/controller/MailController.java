package com.example.issue.sys.mail.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.issue.api.service.ApiService;
import com.example.issue.api.vo.ApiVo;
import com.example.issue.api.vo.NewsVo;
import com.example.issue.api.vo.StockVo;
import com.example.issue.api.vo.WeatherVo;
import com.example.issue.api.vo.WeatherVo.CategoryType;
import com.example.issue.base.controller.BaseController;
import com.example.issue.sys.mail.service.MailService;
import com.example.issue.sys.mail.vo.MailVo;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/sys")
public class MailController extends BaseController{

	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/**
	  * @description 메일 보내기 ajax
	  * @date 2023.01.26
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/mail/sendMail")
	public void newsListAjax(Model model
			, HttpServletResponse response
			, HttpServletRequest request
			, HttpSession session
			, @ModelAttribute("MailVo") MailVo vo) throws Exception {
		
			
		logger.info("sendMail start!!");
	       
        String resultMessage = "";
        String resultCode = mailService.sendMail(vo);
        PrintWriter out = response.getWriter();
        
       
        if(!resultCode.equals("200")) {
        	resultMessage = "데이터가 없습니다.";
        	resultCode = "FAIL";
        }
       
		out.print(getResultModel(resultCode, resultMessage, null, null, 0));
		
	}
	
	
}