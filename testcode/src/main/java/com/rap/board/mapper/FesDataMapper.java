package com.rap.board.mapper;

import java.util.List;

import com.rpa.board.domain.CityVO;
import com.rpa.board.domain.Criteria;
import com.rpa.board.domain.FesDataDTO;

public interface FesDataMapper {
	public int insert(FesDataDTO dto);
	public List<FesDataDTO> getList();
	public FesDataDTO selectOne(int num);
	public List<FesDataDTO> getAddressList(CityVO city);
	
	public List<FesDataDTO> getListWithPagging(Criteria cri);
	public int getTotalCount(CityVO city);

}