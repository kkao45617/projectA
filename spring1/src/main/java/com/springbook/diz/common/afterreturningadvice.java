package com.springbook.diz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.diz.user.userVO;

@Service
@Aspect
public class afterreturningadvice {
	
		
	@Pointcut("execution(* com.springbook.diz..*impl.get*(..))")
	public void getpointcut() {
		
	}
	
	@AfterReturning(pointcut = "getpointcut()", returning = "returnobj")
	public void afterlog(JoinPoint jp, Object returnobj) {
		String method = jp.getSignature().getName();
		
		if(returnobj instanceof userVO) {
			userVO user=(userVO) returnobj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName()+" 로그인 (admin)");
			}
		}
		System.out.println("[사후처리] "+method+"()메소드 리턴값 : "+returnobj.toString());
	}
}
