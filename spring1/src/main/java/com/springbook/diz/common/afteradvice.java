package com.springbook.diz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class afteradvice {
	@Pointcut("execution(* com.springbook.diz..*impl.get*(..))")
	public void allpointcut() {
		
	}
	@After("allpointcut()")
	public void finallylog() {
		System.out.println("[사후처리] 비즈니스 로직 수행 후 무조건 동작");
	}
}
