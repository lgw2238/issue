package com.example.issue;

import java.util.List;

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

@Controller
public class WebController {	
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String jspCheck(Model model) {
		System.out.println("main 화면 접속");

		return "main";
	}
	
	/**
	  * @description (1)날씨 API 화면으로 이동
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