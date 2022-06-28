package com.springbook.diz.user.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.diz.user.userVO;
import com.springbook.diz.user.userservice;

@Service("userservice")
public class userserviceimpl implements userservice{
	@Autowired
	private userDAO userdao;
	
	public void setuserdao(userDAO userdao) {
		this.userdao = userdao;
	}
	
	public userVO getuser(userVO vo) {
		return userdao.getuser(vo);
	}
}
