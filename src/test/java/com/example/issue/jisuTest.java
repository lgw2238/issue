package com.example.issue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.example.issue.api.vo.StockVo;

public class jisuTest {
	  public static void main(String[] args) {
	        final String crawlingEnterUrl = "https://search.naver.com/search.naver?where=nexearch&sm=tab_etc&ie=utf8&query=%EC%A3%BC%EC%9A%94%EC%A6%9D%EC%8B%9C&mra=bjA3";
	        Connection conn = Jsoup.connect(crawlingEnterUrl);
	        List<StockVo> jisuDataList = new ArrayList<StockVo>();	
	        try {
	            Document document = conn.get();
	            Elements kospi = document.getElementsByClass("csp");  
	            Elements kosdaq = document.getElementsByClass("csd"); 
	            Elements etc = document.getElementsByClass("lsttype_tb noline"); 
	            
	            Elements kospiImgUrl = kospi.select("span.img_bx > img");
	            Elements kosdaqImgUrl = kosdaq.select("span.img_bx > img");
//	            for(int i=0; i<kospi.size(); i++) {
//	            	StockVo jisuVo = new StockVo();
//	            	final String kospiText = etc.get(i).text().replaceAll(" ", "|");;
//	            	jisuVo.setJisuDataBody(kospiText);
//	            	jisuDataList.add(jisuVo);
//	            }
//	            
//	            for(int i=0; i<kosdaq.size(); i++) {
//	            	StockVo jisuVo = new StockVo();
//	            	final String kosdaqText = etc.get(i).text().replaceAll(" ", "|");;
//	            	jisuVo.setJisuDataBody(kosdaqText);
//	            	jisuDataList.add(jisuVo);
//	            }
//	            
//	            for(int i=0; i<etc.size(); i++) {
//	            	StockVo jisuVo = new StockVo();
//	            	final String etcText = etc.get(i).text().replaceAll(" ", "|");;
//	            	jisuVo.setJisuDataBody(etcText);
//	            	jisuDataList.add(jisuVo);
//	            }
	               System.out.println("kospiImgUrl:" +kospiImgUrl);
	               System.out.println("kosdaqImgUrl:" +kosdaqImgUrl);
	            	//System.out.println("jisuDataList:" +jisuDataList.toString());

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
