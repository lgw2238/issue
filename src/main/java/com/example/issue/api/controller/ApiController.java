package com.example.issue.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.issue.api.service.ApiService;
import com.example.issue.api.vo.ApiVo;
import com.example.issue.api.vo.WeatherVo;


@RestController
@RequestMapping("/api")
public class ApiController {

	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${WEATHER.API.DECODE.KEY}")
	public String decodeWeatherApiKey;

	@Value("${STOCK.API.DECODE.KEY}")
	public String decodeStockApiKey;
	
	@Autowired
	ApiService apiService;
	/**
	  * @description (1)날씨 API 화면으로 이동
	  * @date 2023.01.16
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/weather")
	public ModelAndView goWeatherApiPage(Model model
			, HttpServletResponse response
			, HttpServletRequest request
			, HttpSession session
			, WeatherVo vo) throws Exception {
		ModelAndView mav = new ModelAndView("api/weather");
		logger.info("weather Api start");
		
		
		List<WeatherVo> localWeather = apiService.selectWeatherData(vo);
		logger.info("localWeather: {}", localWeather.toString());
		
		mav.addObject("localWeather", "localWeather");
		mav.addObject("viewName", "Weather API");	
		return mav;
		
	}

	
	/**
	  * @description (2)주식시세 API 화면으로 이동
	  * @date 2023.01.16
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/stock")
	public ModelAndView goStockApiPage(Model model
			, HttpServletResponse response
			, HttpServletRequest request
			, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("api/stock");
		logger.info("stock Api start");
			
		mav.addObject("viewName", "Stock API");	
		return mav;
		
	}
	
	
	/**
	  * @description (3)관광지 추천 API 화면으로 이동
	  * @date 2023.01.17
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/tourist")
	public ModelAndView goTouristApiPage(Model model
			, HttpServletResponse response
			, HttpServletRequest request
			, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("api/tourist");
		logger.info("Tourist Api start");
			
		mav.addObject("viewName", "Tourist API");	
		return mav;
		
	}
	
	/**
	  * @description (3)관광지 추천 API 화면으로 이동
	  * @date 2023.01.17
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/news")
	public ModelAndView goNewsApiPage(Model model
			, HttpServletResponse response
			, HttpServletRequest request
			, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("api/news");
		logger.info("News Api start");
			
		mav.addObject("viewName", "News API");	
		return mav;
		
	}
}