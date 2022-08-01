package org.zerock.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	public void register(BoardVO vo);
	public BoardVO get(Long bno);
	public int modify(BoardVO vo);
	public int remove(Long bno);
	public List<BoardVO> getList(Criteria cri);
	public int getTotal(Criteria cri);
	
	//이미지 넣기
	public void fileprocess(MultipartHttpServletRequest mul);
	
	
}
