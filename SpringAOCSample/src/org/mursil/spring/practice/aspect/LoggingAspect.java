package org.mursil.spring.practice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LoggingAspect {

	@Pointcut("execution(* get*(..))")
	public void AllGetters(){}
	
	@Before("AllGetters()")
	public void LoggingAdvice(){
		System.out.println("Logging Advice called.");
		
	}
	
	@Before("AllGetters()")
	public void AnotherLoggingAdvice(){
		System.out.println("2nd Logging Advice called.");
		
	}
	
	
	
}
