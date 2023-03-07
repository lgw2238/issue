package com.example.issue.sys.mail.service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.lang.model.element.Element;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.issue.api.service.ApiService;
import com.example.issue.api.vo.ApiResponse;
import com.example.issue.api.vo.ApiVo;
import com.example.issue.api.vo.StockVo;
import com.example.issue.api.vo.ApiVo.Items;
import com.example.issue.api.vo.NewsVo;
import com.example.issue.api.vo.WeatherVo;
import com.example.issue.api.vo.WeatherVo.CategoryType;
import com.example.issue.sys.mail.service.MailService;
import com.example.issue.sys.mail.vo.MailVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MailServiceImpl implements MailService{
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	 @Autowired
	 private JavaMailSender sender;
	 
	 @Override
	 public String sendMail(MailVo vo) throws Exception {
		
		 	String resultCode = "";	    
		    MimeMessage message = sender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message);
		    logger.info("MailVo::mailVo={}", vo.toString());
		    try {
			      helper.setTo(vo.getSendEmail());
			      helper.setSubject("메일 테스트");
			      helper.setText(vo.getSendMessage());
			      resultCode = "200";
		    } catch (MessagingException e) {
		    	  resultCode = "100";	
		    	  e.printStackTrace();
		    	  
		    }
		   
		    sender.send(message);
		    logger.info("resultCode:{}", resultCode);;
		    return resultCode;
	}
	
	
}


