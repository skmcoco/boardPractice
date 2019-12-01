package com.spring.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.LineListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.dto.BoardDto;
import com.spring.board.form.BoardForm;
import com.spring.board.serivce.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardService boardSerivce;
	
	@RequestMapping(value = "/boardList")
	public String getBoardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "board/boardList";
	}
	
	@RequestMapping(value = "/getBoardList")
	@ResponseBody
	public List<BoardDto> getBoardList(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {
		
		List<BoardDto> boardList = boardSerivce.getBoardList(boardForm);
		
		return boardList;
	}
}
