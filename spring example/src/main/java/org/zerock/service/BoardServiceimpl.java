package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceimpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO vo) {
		log.info("register______________________________");
		//mapper.insert(vo);
		mapper.insertselectkey(vo);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int remove(Long bno) {
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}
	
}
