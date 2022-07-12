package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface timemapper {

	@Select("select * from dual")
	public String gettime();
	
	public String gettime2();
}
