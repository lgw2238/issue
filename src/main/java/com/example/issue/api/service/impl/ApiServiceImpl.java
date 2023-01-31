package com.example.issue.api.service.impl;

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
import org.springframework.stereotype.Service;

import com.example.issue.api.service.ApiService;
import com.example.issue.api.vo.ApiResponse;
import com.example.issue.api.vo.ApiVo;
import com.example.issue.api.vo.StockVo;
import com.example.issue.api.vo.TouristVo;
import com.example.issue.api.vo.ApiVo.Items;
import com.example.issue.api.vo.NewsVo;
import com.example.issue.api.vo.WeatherVo;
import com.example.issue.api.vo.WeatherVo.CategoryType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiServiceImpl implements ApiService{
	
	@Value("${WEATHER.API.ENCODE.KEY}")
	public String encodeWeatherApiKey;

	@Value("${STOCK.API.DECODE.KEY}")
	public String decodeStockApiKey;
	
	@Value("${STOCK.ExchangeRate.API.KEY}")
	public String exchangeRateApiKey;
		
	@Value("${NEWS.CRAWLING.URL}")
	public String crawlingUrl;
	
	@Value("${NEWS.ENTER.URL}")
	public String crawlingEnterUrl;
	
	@Value("${TOUR.API.ENCODE.KEY}")
	public String tourApiKey;
	

	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<WeatherVo> selectWeatherData(WeatherVo vo) throws Exception {
		logger.info("decodeWeatherApiKey:{}", encodeWeatherApiKey);
	    String BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
		String serviceKey = encodeWeatherApiKey; /*공공데이터포털에서 받은 인증키*/
		List<WeatherVo> weatherDataList = new ArrayList<WeatherVo>();	
		
		/* 오늘 날짜 */
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        logger.info("strToday:{}", strToday);
        /* 현재 시간 */
        LocalTime now = LocalTime.now();
        // 시, 분
        int hour = now.getHour()-1;
        int minute = now.getMinute();
        String strTime = (Integer.toString(hour)+"00");
        logger.info("strTime:{}", strTime);
		/* api 정보 담을 객체 생성  */
		WeatherVo weather = new WeatherVo();
		
	  try {
			  
		    StringBuilder urlBuilder = new StringBuilder(BASE_URL);
		    urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
		    urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode(strToday, "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode("0800", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode("55", "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode("127", "UTF-8"));
		    	    	   		    
		    logger.info("Request url {}", urlBuilder.toString());
		    		    
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
		    int i = 0;
		    for (WeatherVo item : items.getItem()) {
		    	  logger.info("count:"+i+"", i);
		    	  logger.info("item:"+item+"",item.toString());
		    	  methodWeather.setCategory(item.getCategory());
		      if (item.getCategory() == CategoryType.T3H) {	    	  

		      } else if (item.getCategory() == CategoryType.REH) {
		    	  		    
		      } else if (item.getCategory() == CategoryType.SKY) {
	
		      } else if (item.getCategory() == CategoryType.PTY) {
		    	  
		      } else if (item.getCategory() == CategoryType.TMP) { // 온도
		    	  methodWeather.setFcstValue(item.getFcstValue());
		      } else if (item.getCategory() == CategoryType.PCP) {
		
		      } else {
		    	  
		      }
		      i++;
		    }
		  } catch (JsonMappingException e) {
		    e.printStackTrace();
		  } catch (JsonProcessingException e) {
		    e.printStackTrace();
		  } catch (NullPointerException e) {
			logger.info("NullPointerException");
			e.printStackTrace();
		 }
		return methodWeather;
	}

	@Override
	public String selectApiData(ApiVo vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockVo> selectExchangeRateData(StockVo vo) throws Exception {
		 String BASE_URL = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
		 String serviceKey = exchangeRateApiKey;
		 List<StockVo> exchangeRateDataList = new ArrayList<StockVo>();	
		 
		 /* 오늘 날짜 */
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        Calendar c1 = Calendar.getInstance();
	        String strToday = sdf.format(c1.getTime());
	        
	        /* 현재 시간 */
	        LocalTime now = LocalTime.now();
	        // 시, 분
	        int hour = now.getHour();
	        int minute = now.getMinute();
	        String strTime = (Integer.toString(hour)+Integer.toString(minute));	        
	        
		try {
			  
		    StringBuilder urlBuilder = new StringBuilder(BASE_URL);
		    urlBuilder.append("?" + URLEncoder.encode("authkey", "UTF-8") + "=" + serviceKey);
		    urlBuilder.append("&" + URLEncoder.encode("searchdate", "UTF-8") + "=" + URLEncoder.encode(strToday, "UTF-8"));
		    urlBuilder.append("&" + URLEncoder.encode("data", "UTF-8") + "=" + URLEncoder.encode("AP01", "UTF-8")); // AP01 : 환율정보 
	    	    	   		    
		    System.out.println(urlBuilder.toString());
		    		    
		    URL url = new URL(urlBuilder.toString());
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setRequestMethod("GET");
		    conn.setRequestProperty("Content-type", "application/json");
		    System.out.println("Response code: " + conn.getResponseCode());
		    String data;
		    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		        StringBuilder sb = new StringBuilder();
		
		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        in.lines().forEach(line -> {
		          sb.append(line);
		        });
		
		        in.close();
		        conn.disconnect();
		        
		        data = sb.toString();
		        System.out.println(sb);
		        	        
		        JSONParser parser = new JSONParser();
		        JSONArray jsonArray = (JSONArray) parser.parse(data);
		        System.out.println(jsonArray);
		      
		        for(int i = 0; i < jsonArray.size(); i++) {
		        	/* api 정보 담을 객체 생성  */
			        StockVo exchangeRate = new StockVo();	
			        
		        	JSONObject obj = (JSONObject) jsonArray.get(i);	
		        	 if(obj != null) {		        		 
		        		 exchangeRate.setCurName((String) obj.get("cur_nm"));
			        	 exchangeRate.setBillName((String) obj.get("cur_unit"));
			        	 exchangeRate.setSendTax((String) obj.get("tts"));
			        	 exchangeRate.setReceiveTax((String) obj.get("ttb"));
			        	 exchangeRate.setStandatdTax((String) obj.get("deal_bas_r"));			        	 
		        	 }else { // obj 가 null 인 경우
		        		 
		        	 	}		   
			        	 if(exchangeRate.getBillName().equals("USD") || exchangeRate.getBillName().equals("JPY(100)") ||
			        		exchangeRate.getBillName().equals("EUR") || exchangeRate.getBillName().equals("CNH") ||
			        		exchangeRate.getBillName().equals("EUR") || exchangeRate.getBillName().equals("THB")) {
			        		exchangeRateDataList.add(exchangeRate);		 
			        	 }
		        	       	 
		        	}		        
		        logger.info("exchangeRateDataList:{}", exchangeRateDataList);
		    	}
		  } catch (Exception e) {
		    e.printStackTrace();
		  }  
		
		return exchangeRateDataList;
	}
	
	
	
	/* 최신뉴스 크롤링 */
	@Override
	public List<NewsVo> selectCurrentNewsList(NewsVo vo) throws Exception {
//			List<sda> list = ??sercei.selectCurrentNewsList(Txconts.crawlingUrl,TXC.crawlingEnterUrl,'asdasd');
			
			
	        String incrawlingUrl = crawlingUrl;        
	        String entercrawlingUrl = crawlingEnterUrl;
	        
	        Connection conn = Jsoup.connect(incrawlingUrl);
	        Connection connEnter = Jsoup.connect(entercrawlingUrl);
	        List<NewsVo> newsList = new ArrayList<NewsVo>();	
	        logger.info("conn:{}", conn);
	        logger.info("connEnter:{}", connEnter);
	        Integer validationInt = 0;
	        loop:
	        try {
	        	// 
	        	for (int cnt = 0; cnt< 2; cnt++) {
	        		if(validationInt == 0) {
	        			Document document = conn.get();
	        			Elements imageUrlElements = document.getElementsByClass("photo");           
	        			Elements titleElements = document.select("dt.photo > a");
	        			Elements titleElements2 = document.select("dt.photo > a > img");
	        			Elements writingElements = document.getElementsByClass("writing");  
	        			/* 최신 경제 뉴스 리스트업 */
	        			for (int j = 0; j < 10; j++) {
	        				NewsVo news = new NewsVo();
	        				final String title = titleElements2.get(j).absUrl("alt").replace("https://news.naver.com/main/", "");
	        				final String titlelink = titleElements.get(j).absUrl("href");               
	        				final String titlePhoto = titleElements2.get(j).absUrl("src");
	        				final String writer = writingElements.get(j).text();
	        				final String genre = "economic";
	        				news.setTitle(title);     
	        				news.setTitleLink(titlelink);
	        				news.setTitlePhotoLink(titlePhoto);
	        				news.setWriter(writer);
	        				news.setGenre(genre);
	        				newsList.add(news);
	        				if ( j == 9) { /* 마지막 for문 에서  validationInt + 1 -> 뉴스 URL 변환 */
	        					validationInt += 1;
	        					logger.info("validationInt endpoint:{}", validationInt);
	        					break;
	        					
	        				}
	        			}
	        		}else if(validationInt.equals(1)){
	        			/* change 연예뉴스 리스트업 */	       
	        			logger.info("change 연예뉴스 리스트업:{}", validationInt);
	        			Document documentEnter = connEnter.get();
	        			Elements enterUrlElements = documentEnter.getElementsByClass("lst_item _page_no_1");   
	        			Elements titleUrlElements = documentEnter.getElementsByClass("title_area");   
	        			Elements titleElements2 = documentEnter.select("div.title_area > a.title");
	        			Elements titleElements3 = documentEnter.select("a.thumb_area > img");
	        			/* 연예 뉴스 리스트 업  */
	        			for (int i=0; i< 6; i++) {
	        				NewsVo enterNews = new NewsVo();
	        				final String enterTitle = titleElements2.get(i).text();
	        				final String enterImgLink = titleElements3.get(i).absUrl("src");
	        				final String enterTag = titleElements2.get(i).absUrl("href");
	        				final String genre = "enter";
	        				enterNews.setTitle(enterTitle); 
	        				enterNews.setTitleLink(enterTag);
	        				enterNews.setTitlePhotoLink(enterImgLink);
	        				enterNews.setWriter(null);
	        				enterNews.setGenre(genre);
	        				newsList.add(enterNews);
	        			}
	        		}else {
	        			
	        		}
	        	}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    logger.info("newsList:{}", newsList);
        return newsList;
        
	}

	@Override
	public List<WeatherVo> selectWeatherDataList(WeatherVo vo) throws Exception {
	
		return null;
	}
	
	
	@Override
	public List<TouristVo> selectTouristDataList(TouristVo vo) throws Exception {
		 String BASE_URL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList";
		 String serviceKey = tourApiKey; 
		 List<TouristVo> touristDataList = new ArrayList<TouristVo>();	
		 String areaCodeValue = vo.getAreaCode();
	     
		 logger.info("지역코드 명:{}", areaCodeValue);
		 if(areaCodeValue == null || areaCodeValue.equals("")) {
			 areaCodeValue = "1";
		 }
		try {
			  
		    StringBuilder urlBuilder = new StringBuilder(BASE_URL);
		    urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("O", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode(areaCodeValue, "UTF-8"));
//			urlBuilder.append("&" + URLEncoder.encode("sigunguCode", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
//			urlBuilder.append("&" + URLEncoder.encode("cat1", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
//			urlBuilder.append("&" + URLEncoder.encode("cat2", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
//			urlBuilder.append("&" + URLEncoder.encode("cat3", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
	    	    	   		    
		    System.out.println(urlBuilder.toString());
		    		    
		    URL url = new URL(urlBuilder.toString());
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setRequestMethod("GET");
		    conn.setRequestProperty("Content-type", "application/json");
		    System.out.println("Response code: " + conn.getResponseCode());
		    String data;
		    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		        StringBuilder sb = new StringBuilder();
		
		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        in.lines().forEach(line -> {
		          sb.append(line);
		        });
		
		        in.close();
		        conn.disconnect();
		        
		        data = sb.toString();

		        /* API 응답값이 json array 형식 -> object 변환 */
		        JSONParser jsonParser = new JSONParser();
		        JSONObject jsonObject = (JSONObject)jsonParser.parse(data);
		        JSONObject response = (JSONObject)jsonObject.get("response");
		        JSONObject body = (JSONObject)response.get("body");
		        JSONObject item = (JSONObject)body.get("items");		        
		        JSONArray jsonArray = (JSONArray)item.get("item");

		        logger.info("jsonArray:{}", jsonArray);
		        for(int i = 0; i < jsonArray.size(); i++) {
		        	/* api 정보 담을 객체 생성  */
			        TouristVo tourist = new TouristVo();	
			        
		        	JSONObject jobj = (JSONObject) jsonArray.get(i);	
		        	 if(jobj != null) {		
		        		 tourist.setNum(i);
		        		 tourist.setAreaCode((String) jobj.get("areacode"));
		        		 tourist.setStandardAddr((String) jobj.get("addr1"));
		        		 tourist.setDetailAddr((String) jobj.get("addr2"));		        		 
		        		 tourist.setFirstimage((String) jobj.get("firstimage"));
		        		 tourist.setSigungucode((String) jobj.get("sigungucode"));
		        		 tourist.setTitle((String) jobj.get("title"));
		        		 tourist.setZipcode((String) jobj.get("zipcode"));
		        		 tourist.setTelNum((String) jobj.get("tel"));
		        		 touristDataList.add(tourist);
		        	 }else {
		        		 
		        	 }		   		
		        	        	       	 
		        }		        
		        logger.info("touristDataList:{}", touristDataList);
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }  
		return touristDataList;
	}

	@Override
	public List<TouristVo> selectAreaCodeList() throws Exception {
		 String BASE_URL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode";
		 String serviceKey = tourApiKey; 
		 List<TouristVo> areaCodeList = new ArrayList<TouristVo>();	
			try {
				  
			    StringBuilder urlBuilder = new StringBuilder(BASE_URL);
			    urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
				urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("20", "UTF-8"));
				urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
				urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
				urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));
				urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
			    System.out.println(urlBuilder.toString());
			    		    
			    URL url = new URL(urlBuilder.toString());
			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    conn.setRequestMethod("GET");
			    conn.setRequestProperty("Content-type", "application/json");
			    System.out.println("Response code: " + conn.getResponseCode());
			    String data;
			    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			        StringBuilder sb = new StringBuilder();
			
			        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			        in.lines().forEach(line -> {
			          sb.append(line);
			        });
			
			        in.close();
			        conn.disconnect();
			        
			        data = sb.toString();

			        /* API 응답값이 json array 형식 -> object 변환 */
			        JSONParser jsonParser = new JSONParser();
			        JSONObject jsonObject = (JSONObject)jsonParser.parse(data);
			        JSONObject response = (JSONObject)jsonObject.get("response");
			        JSONObject body = (JSONObject)response.get("body");
			        JSONObject item = (JSONObject)body.get("items");		        
			        JSONArray jsonArray = (JSONArray)item.get("item");

			        logger.info("jsonArray:{}", jsonArray);
			        for(int i = 0; i < jsonArray.size(); i++) {
			        	/* api 정보 담을 객체 생성  */
				        TouristVo areaData = new TouristVo();	
				        
			        	JSONObject jobj = (JSONObject) jsonArray.get(i);	
			        	 if(jobj != null) {		
			        		 areaData.setNum(i);
			        		 areaData.setAreaCode((String) jobj.get("code"));
			        		 areaData.setAreaNm((String) jobj.get("name"));
			        		 areaCodeList.add(areaData);
			        	 }else {
			        		 
			        	 }		   		    	       	 
			        }		        
			       logger.info("areaCodeList:{}", areaCodeList);
			    }
			  } catch (Exception e) {
			    e.printStackTrace();
			  }  
			return areaCodeList;

	}
	
}


