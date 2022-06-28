package com.springbook.diz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class logadvice {
	@Pointcut("execution(* com.springbook.diz..*impl.*(..))")
	public void allpointcut() {
		
	}
	@Pointcut("execution(* com.springbook.diz..*impl.get*(..))")
	public void getpointcut() {
		
	}
	
	
	@Before("getpointcut()")
	public void printlog() {
		System.out.println("[공통로그]비즈니스 로직 수행전 동작");
		
	}
}
