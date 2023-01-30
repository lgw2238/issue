package com.example.issue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.example.issue.api.vo.TouristVo;

import net.minidev.json.JSONUtil;


public class tourist {


	/* test 코드 */
	public static void main(String[] args) throws Exception {
			
		 String BASE_URL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList";
		 String serviceKey = "%2Bum%2FLM6KjzLGLLV45nZ%2Bwp3SP1KGO1ZUXZa7fabXkWZpMt6vk6AM9%2FXjbvIKzfyeiaeUWK0WBiWIChFh1BALLw%3D%3D"; 
		 List<TouristVo> touristDataList = new ArrayList<TouristVo>();	
		 
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
		    urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + serviceKey);
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("30", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("O", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + URLEncoder.encode("32", "UTF-8"));
	    	    	   		    
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
		        System.out.println(data);
		        /* API 응답값이 json array 형식 */
		        JSONParser jsonParser = new JSONParser();
		        JSONObject jsonObject = (JSONObject)jsonParser.parse(data);
		        JSONObject response = (JSONObject)jsonObject.get("response");
		        JSONObject body = (JSONObject)response.get("body");
		        JSONObject item = (JSONObject)body.get("items");
		        
		        JSONArray jsonArray = (JSONArray)item.get("item");
		        System.out.println("response"+response);
		        System.out.println("body"+body);
		        System.out.println("item"+item);
		        System.out.println("jsonArray"+jsonArray);
		        int count = 0;
		        for(int i = 0; i < jsonArray.size(); i++) {
		        	/* api 정보 담을 객체 생성  */
			        TouristVo tourist = new TouristVo();	
			        
		        	JSONObject jobj = (JSONObject) jsonArray.get(i);
		        	String validationTelNum = (String) jobj.get("tel");
		        	 if(jobj != null && !validationTelNum.equals("")) {			        		
		        		 tourist.setNum(i);
		        		 tourist.setAreacode((String) jobj.get("areacode"));
		        		 tourist.setStandardAddr((String) jobj.get("addr1"));
		        		 tourist.setDetailAddr((String) jobj.get("addr2"));		        		 
		        		 tourist.setFirstimage((String) jobj.get("firstimage2"));
		        		 tourist.setSigungucode((String) jobj.get("sigungucode"));
		        		 tourist.setTitle((String) jobj.get("title"));
		        		 tourist.setZipcode((String) jobj.get("zipcode"));
		        		 tourist.setTelNum((String) jobj.get("tel"));
		        		 touristDataList.add(tourist);
		        		 
		        		 count += 1;
		        		 if(count == 9) {
		        			 break;
		        		 }
		        	 }else {
		        		 
		        	 }		   		
		        	 System.out.println(i);		        	       	 
		        }		        
		       System.out.println(touristDataList);
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }  
	  

	}
}
