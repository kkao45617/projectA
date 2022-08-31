package com.rpa.board.service;

import java.util.List;

import com.rpa.board.domain.BoardVO;
import com.rpa.board.domain.Criteria;

public interface BoardService {
   public void register(BoardVO vo);
   public BoardVO get(int boardNum);
   public int modify(BoardVO vo);
   public int remove(int boardNum);
   public List<BoardVO> getList(Criteria cri);
   public int getTotal(Criteria cri);
}