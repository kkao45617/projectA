package com.springbook.diz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class boardserviceclient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("appilcationcontext2.xml");
		
		boardservice boardservice =(boardservice)container.getBean("boardservice");
		
		boardVO vo = new boardVO();
		vo.setTitle("?��?��?���?");
		vo.setWriter("?��길동");
		vo.setContent("?��?��?��?��");
		boardservice.insertboard(vo);
		
		List<boardVO> boardlist = boardservice.getboardlist(vo);
		for(boardVO board:boardlist) {
			System.out.println("--->"+board);
		}
		
		container.close();
	}
}
