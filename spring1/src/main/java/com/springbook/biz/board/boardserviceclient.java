package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class boardserviceclient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("appilcationcontext2.xml");
		
		boardservice boardservice =(boardservice)container.getBean("boardservice");
		
		boardVO vo = new boardVO();
		vo.setSeq(100);
		vo.setTitle("이순신");
		vo.setWriter("나와라");
		vo.setContent("나왔을까!!");
		boardservice.insertboard(vo);
		
		List<boardVO> boardlist = boardservice.getboardlist(vo);
		for(boardVO board:boardlist) {
			System.out.println("--->"+board.toString());
		}
		
		container.close();
	}
}
