package com.example.issue.api.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.issue.api.service.ApiService;
import com.example.issue.api.vo.ApiResponse;
import com.example.issue.api.vo.ApiVo;
import com.example.issue.api.vo.ApiVo.Items;
import com.example.issue.api.vo.WeatherVo;
import com.example.issue.api.vo.WeatherVo.CategoryType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiServiceImpl implements ApiService{
	@Value("${WEATHER.API.DECODE.KEY}")
	public String decodeWeatherApiKey;

	@Value("${STOCK.API.DECODE.KEY}")
	public String decodeStockApiKey;
	
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	
	private final String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
	private final String serviceKey = decodeWeatherApiKey; /*공공데이터포털에서 받은 인증키*/
		
	
	@Override
	public List<WeatherVo> selectWeatherData(WeatherVo vo) throws Exception {
		
		
		List<WeatherVo> weatherDataList = new ArrayList<WeatherVo>();	
		
		/* api 정보 담을 객체 생성  */
		WeatherVo weather = new WeatherVo();
		
	  try {
			  
		    StringBuilder urlBuilder = new StringBuilder(BASE_URL);
		    urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
		    urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode("20200807", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode("1100", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode("76", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode("122", "UTF-8"));
		
		    URL url = new URL(urlBuilder.toString());
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setRequestMethod("GET");
		    conn.setRequestProperty("Content-type", "application/json");
		    logger.info("Response code: " + conn.getResponseCode());
		
		    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		        StringBuilder sb = new StringBuilder();
		
		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        in.lines().forEach(line -> {
		          sb.append(line);
		        });
		
		        in.close();
		        conn.disconnect();
		
		        logger.info(sb.toString());
		        
		        /* 날씨 정보 JSON 가공 */
		        weather = setWeatherInfo(sb.toString());
		        
		        weatherDataList.add(weather);
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }  
	  
	  return weatherDataList;
	}	
	
	/**
	  * 날씨정보 데이터 파싱
	  * @param json
	  */
	private WeatherVo setWeatherInfo(String json) {
		WeatherVo methodWeather = new WeatherVo();
		  try {
		    ObjectMapper objectMapper = new ObjectMapper();
		    ApiResponse data = objectMapper.readValue(json, ApiResponse.class);	
		    Items items = data.getResponse().getBody().getItems();
		    
		    logger.info("items:{}",items);
		    
		    for (WeatherVo item : items.getItem()) {
		      if (item.getCategory() == CategoryType.T3H) {
		    	  
		      } else if (item.getCategory() == CategoryType.REH) {
		    	  
		      } else if (item.getCategory() == CategoryType.SKY) {
	
		      } else if (item.getCategory() == CategoryType.PTY) {
		    	  
		      }
		    }
		  } catch (JsonMappingException e) {
		    e.printStackTrace();
		  } catch (JsonProcessingException e) {
		    e.printStackTrace();
		 }
		return methodWeather;
	}

	@Override
	public String selectApiData(ApiVo vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}


