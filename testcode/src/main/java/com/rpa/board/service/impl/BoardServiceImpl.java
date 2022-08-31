package com.rpa.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rap.board.mapper.BoardMapper;
import com.rpa.board.domain.BoardVO;
import com.rpa.board.domain.Criteria;
import com.rpa.board.service.BoardService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
   private BoardMapper mapper;

   public void register(BoardVO vo) {
      System.out.println("register Impl ... start...");
      mapper.insertSelectKey(vo);
   }

   @Override
   public BoardVO get(int boardNum) {
      return mapper.get(boardNum);
   }

   @Override
   public int modify(BoardVO vo) {
      return mapper.update(vo);
   }

   @Override
   public int remove(int boardNum) {
      return mapper.delete(boardNum);
   }

   @Override
   public List<BoardVO> getList(Criteria cri) {
      return mapper.getListWithPagging(cri);
   }
   
   public int getTotal(Criteria cri) {
      return mapper.getTotalCount(cri);
   }

}