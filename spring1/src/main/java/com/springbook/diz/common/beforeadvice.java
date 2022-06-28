package com.springbook.diz.common;

import org.aspectj.lang.JoinPoint;

public class beforeadvice {
	public void beforelog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전처리] "+ method+"() 메소드 args 정보 :"+args[0].toString());
		
		
	}
}
