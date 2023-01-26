package com.example.issue;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class crawling {

    public static void main(String[] args) {
        final String incrawlingUrl = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=101&sid2=262";
        Connection conn = Jsoup.connect(incrawlingUrl);

        try {
            Document document = conn.get();
            Elements imageUrlElements = document.getElementsByClass("photo");           
            Elements titleElements = document.select("dt.photo > a");
            Elements titleElements2 = document.select("dt.photo > a > img");

//            for (int j = 0; j < titleElements.size(); j++) {
            for (int j = 0; j < 10; j++) {
            	final String title = titleElements2.get(j).absUrl("alt").replace("https://news.naver.com/main/", "");
            	final String titlelink = titleElements.get(j).absUrl("href");               
            	final String titlePhoto = titleElements2.get(j).absUrl("src");
            	
                System.out.println("title:"+title);
                System.out.println("titlelink:"+titlelink);
                System.out.println("titlePhoto:"+titlePhoto);               
            }
          
            for (Element element : imageUrlElements) {
                System.out.println(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}