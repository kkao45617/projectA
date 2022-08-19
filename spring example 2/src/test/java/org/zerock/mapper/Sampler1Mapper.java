package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sampler1Mapper {
	
	@Insert("insert into tbl_sample1(call) values(#{data})")
	public int insertcol1(String data);
}
