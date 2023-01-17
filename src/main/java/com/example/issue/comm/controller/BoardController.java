package com.example.issue.comm.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.issue.comm.model.BoardVo;
import com.example.issue.comm.service.BoardService;


/*@CrossOrigin(origins = "http://localhost:3000")*/
@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
			System.out.println("home controller start");
	                   
	        return "index";
	    }
	
	
	@GetMapping("/getList")
	public List<BoardVo> getAllBoards() {
		
		return boardService.getAllBoard();
//	
//	// get paging board 
//	@GetMapping("/board")
//	public ResponseEntity<Map> getAllBoards(@RequestParam(value = "p_num", required=false) Integer p_num) {
//		if (p_num == null || p_num <= 0) p_num = 1;
//		
//		return boardService.getPagingBoard(p_num);
//	}
	

//	}
//
//	// create board
//	@PostMapping("/board")
//	public Board createBoard(@RequestBody Board board) {
//		System.out.println("@PostMapping(\"/board\")");
//		System.out.println(board.toString());
//		return boardService.createBoard(board);
//	}
//	
//	// get board
//	@GetMapping("/board/{no}")
//	public ResponseEntity<Board> getBoardByNo(
//			@PathVariable Integer no) {
//		
//		return boardService.getBoard(no);
//	}
//	
//	// update board
//	@PutMapping("/board/{no}")
//	public ResponseEntity<Board> updateBoardByNo(
//			@PathVariable Integer no, @RequestBody Board board){
//		
//		return boardService.updateBoard(no, board);
//	}
//	
//	// delete board
//	@DeleteMapping("/board/{no}")
//	public ResponseEntity<Map<String, Boolean>> deleteBoardByNo(
//			@PathVariable Integer no) {
//		
//		return boardService.deleteBoard(no);
//	}
//	
	}
}