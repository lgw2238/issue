package com.example.issue;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.issue.api.vo.WeatherVo;
import com.example.issue.util.deviceUtil;

@Controller
public class WebController {	
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String jspCheck(Model model) {
		LocalDateTime localDateTime = LocalDateTime.now();
        String localDateTimeStr = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		String realIp = deviceUtil.getServerIp();
		logger.info("======================================");
		logger.info("접속 IP: {}", realIp);
		logger.info("접속 시간: {}", localDateTimeStr);
		logger.info("======================================");
		
		return "main";
	}
	
	/**
	  * @description (1) about Me 이동
	  * @date 2023.01.16
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/about")
	public ModelAndView goWeatherApiPage(Model model
			, HttpServletResponse response
			, HttpServletRequest request
			, HttpSession session
			, WeatherVo vo) throws Exception {
		ModelAndView mav = new ModelAndView("/about");
		logger.info("Go aboutMe");

		mav.addObject("viewName", "aboutMe");	
		return mav;
		
	}
}