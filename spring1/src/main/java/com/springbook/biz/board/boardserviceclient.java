package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class boardserviceclient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("appilcationcontext2.xml");
		
		boardservice boardservice =(boardservice)container.getBean("boardservice");
		
		boardVO vo = new boardVO();
		vo.setTitle("임시제목");
		vo.setWriter("홍길동");
		vo.setContent("임시내용");
		boardservice.insertboard(vo);
		
		List<boardVO> boardlist = boardservice.getboardlist(vo);
		for(boardVO board:boardlist) {
			System.out.println("--->"+board);
		}
		
		container.close();
	}
}
