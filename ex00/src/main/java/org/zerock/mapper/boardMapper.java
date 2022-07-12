package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.boardVO;

public interface boardMapper {
	
	public List<boardVO> getList();
	
	public void insert(boardVO vo);
	
	public void insertselectkey(boardVO vo);
	
	public boardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(boardVO vo);
}
