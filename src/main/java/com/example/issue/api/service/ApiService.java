package com.example.issue.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.issue.api.vo.ApiVo;
import com.example.issue.api.vo.WeatherVo;
import com.example.issue.comm.model.BoardVo;
import com.example.issue.comm.repository.BoardRepository;


public interface ApiService {


	public String selectApiData(ApiVo vo) throws Exception;
	/**
	 * @description API 목록 조회
	 * @date 2023.01.16
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	public List<WeatherVo> selectWeatherData(WeatherVo vo) throws Exception;
	
 

}
