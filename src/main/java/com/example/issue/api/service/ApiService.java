package com.example.issue.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.issue.api.vo.ApiVo;
import com.example.issue.api.vo.NewsVo;
import com.example.issue.api.vo.StockVo;
import com.example.issue.api.vo.TouristVo;
import com.example.issue.api.vo.WeatherVo;
import com.example.issue.comm.model.BoardVo;
import com.example.issue.comm.repository.BoardRepository;


public interface ApiService {


	public String selectApiData(ApiVo vo) throws Exception;
	/**
	 * @description API 목록 조회(1) - 날씨정보(BETA)
	 * @date 2023.01.16
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	public List<WeatherVo> selectWeatherData(WeatherVo vo) throws Exception;
	
	
	/**
	 * @description API 목록 조회(1) - 날씨정보(NEW)
	 * @date 2023.01.16
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	public List<WeatherVo> selectWeatherDataList(WeatherVo vo) throws Exception;
	
	/**
	 * @description API 목록 조회(2) - 환율 시세
	 * @date 2023.01.19
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	public List<StockVo> selectExchangeRateData(StockVo vo) throws Exception;

	
	/**
	 * @description API 목록 조회(2-1) - 주식 상위종목 조회 크롤링 데이터
	 * @date 2023.01.19
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	public List<StockVo> selectStockDataList(StockVo vo) throws Exception;
	
	/**
	 * @description API 목록 조회(2-2) - 환율 정보 조회 크롤링
	 * @date 2023.02.13
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	public List<StockVo> selectExchangeDataList(StockVo vo) throws Exception;
	
	/**
	 * @description API 목록 조회(2-3) - 지수 정보 조회 크롤링
	 * @date 2023.02.13
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	public List<StockVo> selectJisuDataList(StockVo vo) throws Exception;
	
	/**
	 * @description API 목록 조회(3) - 지역코드 조회
	 * @date 2023.01.31
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	
	public List<TouristVo> selectAreaCodeList() throws Exception;
	
	
	/**
	 * @description API 목록 조회(3) - 관광지 데이터 조회
	 * @date 2023.01.30
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	public List<TouristVo> selectTouristDataList(TouristVo vo) throws Exception;
	
	
	
	/**
	 * @description API 목록 조회(4) - 최신 뉴스
	 * @date 2023.01.26
	 * @author lgw
	 * @return
	 * @throws Exception
	 */
	public List<NewsVo> selectCurrentNewsList(NewsVo vo) throws Exception;
	
	
	
	
}
