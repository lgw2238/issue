package com.example.issue;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class exchange {
	  public static void main(String[] args) {
	        final String crawlingEnterUrl = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%ED%99%98%EC%9C%A8&oquery=%ED%99%98%EC%9C%A8+%EC%A6%9D%EC%8B%9C&tqi=h%2BrOAdp0J1ZssNEy734ssssss9Z-415936";
	        Connection conn = Jsoup.connect(crawlingEnterUrl);

	        try {
	            Document document = conn.get();
	            Elements stockTitleElements = document.getElementsByClass("rate_table_info");  
	            Elements test1 = stockTitleElements.select("tr.dw");
	            Elements test2 = stockTitleElements.select("tr.up");
	            Elements exChangeTrUpElements = document.getElementsByClass("up");
	            Elements exChangeTrDownElements = document.getElementsByClass("dw");
	            
	            for(int i=0; i<test2.size(); i++) {
	            /*	final String Title = ;*/
	            	final String exchange = exChangeTrUpElements.get(i).text();
					/* final String upPoint = ; */
	            	System.out.println("exchange"+exchange.replaceAll(" ", "|"));
	            }
	            
	            
	            for(int i=0; i<test1.size(); i++) {
	            /*	final String Title = ;*/
	            	final String exchange2 = exChangeTrDownElements.get(i).text();
					/* final String upPoint = ; */
	            	System.out.println("exchange2"+exchange2.replaceAll(" ", "|"));
	            }

	       
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
