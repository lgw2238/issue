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

public class test2 {

	/* test 코드 */
	public static void main(String[] args) throws Exception {
        String a = null;
        String b = "null";
        
        //ex1) 
		System.out.println(" Result : " + a.equals(b));
        // nullPointerException
        //ex2)
        System.out.println(" Result2 : " + b.equals(a));
        // 
       // ex3)
        System.out.println(" Result3 : " + "null".equals(a));
	}
}
