package org.zerock.aop;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
@Aspect//�ش� ��ü�� aspect�� �����ߴ�.
public class LogAdvice {
	//@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("-----------------------");
		
	}
	
	//@Before("execution(* org.zerock.service.SampleService*.doadd(String,String))&& args(str1,str2)")
	public void logbeforeWithParam(String str1,String str2) {
		log.info("str1 : "+str1);
		log.info("str2 : "+str2);
	}
	
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))",throwing = "exception")
	public void logexception(Exception exception) {
		log.info("exception"+exception);
	}
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint ps) {
		long start = System.currentTimeMillis();
		log.info(ps.getTarget());
		log.info(Arrays.toString(ps.getArgs()));
		
		Object result= null;
		
		try {
			result=ps.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end= System.currentTimeMillis();
		log.info("time : " +(end-start));
		return result;
		
	}
}
