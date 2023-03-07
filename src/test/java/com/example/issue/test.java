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

import com.example.issue.api.vo.StockVo;

public class test {

	/* test 코드 */
	public static void main(String[] args) throws Exception {
			
		 String BASE_URL = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
		 String serviceKey = "5LtV5Aq6Nii8aoWjXVLR9qttJambnyn7"; 
		 List<StockVo> exchangeRateDataList = new ArrayList<StockVo>();	
		 
		 /* 오늘 날짜 */
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Calendar c1 = Calendar.getInstance();
	        String strToday = sdf.format(c1.getTime());
	        
	        System.out.println(strToday);
	        /* 현재 시간 */
	        LocalTime now = LocalTime.now();
	        // 시, 분
	        int hour = now.getHour();
	        int minute = now.getMinute();
	        String strTime = (Integer.toString(hour)+Integer.toString(minute));	        
	        
//		try {
//			  
//		    StringBuilder urlBuilder = new StringBuilder(BASE_URL);
//		    urlBuilder.append("?" + URLEncoder.encode("authkey", "UTF-8") + "=" + serviceKey);
//		    urlBuilder.append("&" + URLEncoder.encode("searchdate", "UTF-8") + "=" + URLEncoder.encode(strToday, "UTF-8"));
//		    urlBuilder.append("&" + URLEncoder.encode("data", "UTF-8") + "=" + URLEncoder.encode("AP01", "UTF-8"));
//	    	    	   		    
//		    System.out.println(urlBuilder.toString());
//		    		    
//		    URL url = new URL(urlBuilder.toString());
//		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		    conn.setRequestMethod("GET");
//		    conn.setRequestProperty("Content-type", "application/json");
//		    System.out.println("Response code: " + conn.getResponseCode());
//		    String data;
//		    if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//		        StringBuilder sb = new StringBuilder();
//		
//		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		        in.lines().forEach(line -> {
//		          sb.append(line);
//		        });
//		
//		        in.close();
//		        conn.disconnect();
//		        
//		        data = sb.toString();
//		        System.out.println(sb);
//		        	        
//		        JSONParser parser = new JSONParser();
//		        JSONArray jsonArray = (JSONArray) parser.parse(data);
//		        System.out.println(jsonArray);
//		      
//		        for(int i = 0; i < jsonArray.size(); i++) {
//		        	/* api 정보 담을 객체 생성  */
//			        StockVo exchangeRate = new StockVo();	
//			        
//		        	JSONObject obj = (JSONObject) jsonArray.get(i);	
//		        	 if(obj != null) {
//		        		 
//		        		 exchangeRate.setCurName((String) obj.get("cur_nm"));
//			        	 exchangeRate.setBillName((String) obj.get("cur_unit"));
//			        	 exchangeRate.setSendTax((String) obj.get("tts"));
//			        	 exchangeRate.setReceiveTax((String) obj.get("ttb"));
//			        	 exchangeRate.setStandatdTax((String) obj.get("deal_bas_r"));
//			        	 
//		        	 }else {
//		        		 
//		        	 }		   
//		        	 System.out.println(exchangeRate);
//		        	 System.out.println(i);
//		        	 if(exchangeRate.getBillName().equals("USD") || exchangeRate.getBillName().equals("JPY(100)") ||
//		        		exchangeRate.getBillName().equals("EUR") || exchangeRate.getBillName().equals("CNH") ||
//		        		exchangeRate.getBillName().equals("EUR") || exchangeRate.getBillName().equals("THB")) {
//		        		 exchangeRateDataList.add(exchangeRate);		 
//		        	 }
//		        	       	 
//		        }		        
//				// System.out.println(exchangeRateDataList); 
//		    }
//		  } catch (Exception e) {
//		    e.printStackTrace();
//		  }  
	  
	}
}
