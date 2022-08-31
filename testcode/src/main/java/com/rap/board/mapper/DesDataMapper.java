package com.rap.board.mapper;

import java.util.List;

import com.rpa.board.domain.CityVO;
import com.rpa.board.domain.Criteria;
import com.rpa.board.domain.DesDataDTO;

public interface DesDataMapper {
	public List<DesDataDTO> getList(Criteria cri);
	public int insert(DesDataDTO dto);
	public void register(DesDataDTO dto);
	public DesDataDTO read(Long num);
	public Long delete(Long num);
	public int update(DesDataDTO dto);
	public List<DesDataDTO> getAddressList(CityVO city);
	
	public int getTotalCount(CityVO city);
	public int searchGetTotal(Criteria cri);
	
	public List<DesDataDTO> getListWithPagging(Criteria cri);
	public DesDataDTO selectOne(int num);
}