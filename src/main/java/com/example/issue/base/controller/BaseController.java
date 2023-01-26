package com.example.issue.base.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.issue.api.service.ApiService;
import com.example.issue.comm.model.BoardVo;
import com.example.issue.comm.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {
	@Value("${WEATHER.API.DECODE.KEY}")
	public String decodeWeatherApiKey;

	@Value("${STOCK.API.DECODE.KEY}")
	public String decodeStockApiKey;
	
	@Autowired
	public ApiService apiService;
	
	public String getResultModel(String code, String msg, String paginationTag, Object data) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
				
    	modelMap.put("resultCode", code);
    	modelMap.put("resultMsg", msg);
    	modelMap.put("paginationTag", paginationTag);
    	modelMap.put("resultData", data);
    	
    	return mapper.writeValueAsString(modelMap);
	}

	public String getResultModel(String code, String msg, String paginationTag, Object data, int totalCount) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
    	modelMap.put("resultCode", code);
    	modelMap.put("resultMsg", msg);
    	modelMap.put("paginationTag", paginationTag);
    	modelMap.put("resultData", data);
    	modelMap.put("totalCount", totalCount);
    	
    	return mapper.writeValueAsString(modelMap);
	}
	
}