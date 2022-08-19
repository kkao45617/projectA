package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.Sampler1Mapper;
import org.zerock.mapper.Sampler2Mapper;

import jdk.internal.jline.internal.Log;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleTxServiceimpl implements SampleTxService{
	@Autowired
	private Sampler1Mapper mapper1;
	@Autowired
	private Sampler2Mapper mapper2;
	
	
	@Override
	@Transactional
	public void addData(String value) {
		log.info("mapper..........");
		mapper1.insertcol1(value);
		
		log.info("mapper2............");
		mapper2.insertcol1(value);
		log.info("edn..................");
	}
	
	

	

	


}
