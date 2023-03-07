package com.example.issue.comm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.issue.comm.model.BoardVo;
import com.example.issue.comm.repository.BoardRepository;

@Service
public class BoardService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardRepository boardRepository;
	
    
	public List<BoardVo> getAllBoard() {
		List<BoardVo> list = boardRepository.findAll(); // findAll() 메소드로 테이블의 레코드 리스트를 가져온다.
		logger.info("List<BoardVo> list = {}", list);
		return list;

	}

}