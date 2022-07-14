package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	public void register(BoardVO vo);  //���
	public int modify(BoardVO vo);  //����
	public int remove(Long bno);  //����
	public BoardVO get(Long bno);  //�б�
	public List<BoardVO> getList();  //��ü �б�
	
}
