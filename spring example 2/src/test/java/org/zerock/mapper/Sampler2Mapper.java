package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sampler2Mapper {
	
	@Insert("insert into tbl_sample2(call) values(#{data})")
	public int insertcol1(String data);
}
