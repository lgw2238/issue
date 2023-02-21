package com.example.issue.api.controller;

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
import com.example.issue.api.vo.TouristVo;
import com.example.issue.api.vo.WeatherVo;
import com.example.issue.api.vo.WeatherVo.CategoryType;
import com.example.issue.base.controller.BaseController;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api")
public class ApiController extends BaseController{

	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
		
		
//		List<WeatherVo> localWeather = apiService.selectWeatherData(vo);
//		String todayTemp = localWeather.get(0).getFcstValue();
//		logger.info("localWeather: {}", localWeather.get(0).getFcstValue());
//		
		//mav.addObject("localWeather", localWeather.get(0));
		mav.addObject("viewName", "Weather API");	
		return mav;
		
	}

	
	/**
	  * @description (1-1) 당일 날씨 정보 ajax
	  * @date 2023.01.27
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/weather/weatherListAjax", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public void weatherListAjax(Model model
			, HttpServletResponse response
			, HttpServletRequest request
			, HttpSession session
			, @ModelAttribute("WeatherVo") WeatherVo vo) throws Exception {
		
			
		logger.info("weatherListAjax");
	       
        String resultMessage = "";
        String resultCode = "SUCCESS";
        PrintWriter out = response.getWriter();
       // List<NewsVo> weatherList = apiService.selectWeatherDataList(vo);
        int totalCount = 0; //weatherList.size();
        
       
        if(totalCount <= 0) {
        	resultMessage = "데이터가 없습니다.";
        	resultCode = "FAIL";
        }
       
		out.print(getResultModel(resultCode, resultMessage, null, null, totalCount));
		
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
			, HttpSession session
			, StockVo vo) throws Exception {
		ModelAndView mav = new ModelAndView("api/stock");
		logger.info("stock Api start");

		mav.addObject("viewName", "Stock API");	
		return mav;
		
	}
	
	/**
	  * @description (2-1)주식시세 화면정보 AJAX - KOSPI, KOSDAQ 상위 20 종목 시세
	  * @date 2023.01.16
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/stock/stockListAjax", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public void stockListAjax(HttpServletRequest request, HttpServletResponse response
			, @ModelAttribute("StockVo") StockVo vo, HttpSession session)throws Exception{
		
		  String resultMessage = "";
		  String resultCode ="";
	      PrintWriter out = response.getWriter();
	      String pagingTag = "";
	      List<StockVo> stockDataList = apiService.selectStockDataList(vo);
	      int totalCount = stockDataList.size();
	      logger.info("controller::response::{}" , stockDataList.toString());
		
		out.print(getResultModel(resultCode, resultMessage, null, stockDataList, totalCount));
	}
	
	/**
	  * @description (2-2)주식시세 화면정보 AJAX - 환율정보
	  * @date 2023.02.13
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/stock/exchangeListAjax", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public void exchangeListAjax(HttpServletRequest request, HttpServletResponse response
			, @ModelAttribute("StockVo") StockVo vo, HttpSession session)throws Exception{
		
		  String resultMessage = "";
		  String resultCode ="";
	      PrintWriter out = response.getWriter();
	      String pagingTag = "";
	      List<StockVo> exchangeDataList = apiService.selectExchangeDataList(vo);
	      int totalCount = exchangeDataList.size();
	      logger.info("controller::response::{}" , exchangeDataList.toString());
		
		out.print(getResultModel(resultCode, resultMessage, null, exchangeDataList, totalCount));
	}
	
	
	/**
	  * @description (2-3)주식시세 화면정보 AJAX - 지수정보
	  * @date 2023.02.13
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/stock/jisuListAjax", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public void jisuListAjax(HttpServletRequest request, HttpServletResponse response
			, @ModelAttribute("StockVo") StockVo vo, HttpSession session)throws Exception{
		
		  String resultMessage = "";
		  String resultCode ="";
	      PrintWriter out = response.getWriter();
	      String pagingTag = "";
	      List<StockVo> jisuDataList = apiService.selectJisuDataList(vo);
	      int totalCount = jisuDataList.size();
	      logger.info("controller::response::{}" , jisuDataList.toString());
		
		out.print(getResultModel(resultCode, resultMessage, null, jisuDataList, totalCount));
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
				
		List<TouristVo> areaCodeList = apiService.selectAreaCodeList();
		logger.info("controller:::areaCodeList:{}", areaCodeList);	

		mav.addObject("areaCodeList", areaCodeList);	
		mav.addObject("viewName", "Tourist API");	
		return mav;
		
	}
	
	
	/**
	  * @description (3-1)관광지 정보 리스트업 AJAX
	  * @date 2023.01.30
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="tourist/touristDataAjax" , method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public void touristDataAjax(HttpServletRequest request, HttpServletResponse response
			, @ModelAttribute("TouristVo") TouristVo vo, HttpSession session)throws Exception{
		
		  String resultMessage = "200";
		  String resultCode = "SUCCESS";
	      PrintWriter out = response.getWriter();
	      List<TouristVo> tourList = apiService.selectTouristDataList(vo);
	      int totalCount = tourList.size();
	      
		out.print(getResultModel(resultCode, resultMessage, null, tourList, totalCount));
	}
	
	/**
	  * @description (4)최신 뉴스조회 API 화면으로 이동
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
	
	
	
	/**
	  * @description (4) 최신 뉴스 조회 ajax
	  * @date 2023.01.26
	  * @author lgw
	  * @param req
	  * @param res
	  * @param mav
	  * @return
	  */
	@RequestMapping(value="/news/newsListAjax", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public void newsListAjax(Model model
			, HttpServletResponse response
			, HttpServletRequest request
			, HttpSession session
			, @ModelAttribute("NewsVo") NewsVo vo) throws Exception {
		
			
		logger.info("newsListAjax");
	       
        String resultMessage = "";
        String resultCode = "SUCCESS";
        PrintWriter out = response.getWriter();
        List<NewsVo> newsList = apiService.selectCurrentNewsList(vo);
        int totalCount = newsList.size();
        
       
        if(totalCount <= 0) {
        	resultMessage = "데이터가 없습니다.";
        	resultCode = "FAIL";
        }
       
		out.print(getResultModel(resultCode, resultMessage, null, newsList, totalCount));
		
	}
	
	
}