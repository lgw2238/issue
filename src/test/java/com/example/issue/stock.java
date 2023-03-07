package com.example.issue;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class stock {
	  public static void main(String[] args) {
	        final String crawlingEnterUrl = "https://finance.naver.com/sise/sise_market_sum.naver?sosok=1";
	        Connection conn = Jsoup.connect(crawlingEnterUrl);

	        try {
	            Document document = conn.get();
	            Elements stockTitleElements = document.getElementsByClass("tltle");   
	            Elements stockBodyElements = document.getElementsByAttributeValue("onmouseover", "mouseOver(this)");
	            Elements stockBodyTrElements = stockBodyElements.select("tr");
	            
//	            System.out.println("stockTitleElements:"+ stockTitleElements);
//	            System.out.println("stockBodyElements2:"+ stockBodyTrElements);
	            for (int i=0; i<5; i++) {
	            	final String stockTitle = stockTitleElements.get(i).text();
	            	final String sotckTr = stockBodyTrElements.get(i).text().replace(" ", "|");
	            	System.out.println("stockTitle:" + stockTitle);
	            	System.out.println("sotckTr:" + sotckTr.toString());
	            }
////	           
// //               Elements titleUrlElements = document.getElementsByClass("title_area");   
//	            Elements titleElements = document.getElementsByClass("tltle");
//	            Elements bodyElements = document.getElementsByClass("number");
//	            //System.out.println("enterUrlElements:" + enterUrlElements);
//	            System.out.println("titleElements2:" + titleElements);
//	            System.out.println("titleElements3:" + bodyElements);
//	            	for (int i=0; i<2; i++) {
//	            		final String stockTitle = titleElements.get(i).text();
//	            		final String stockBody = bodyElements.get(i).text();
//	            		//final String enterTag = titleElements2.get(i).absUrl("href");
//	            		
//	            		System.out.println("enterTitle:" +stockTitle);
//	    				System.out.println("enterImgLink:" +stockBody);
//	    				//System.out.println("enterTag:" +enterTag);
//	    				
//	            	}

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
