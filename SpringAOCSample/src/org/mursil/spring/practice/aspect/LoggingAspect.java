package org.mursil.spring.practice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LoggingAspect {

	@Pointcut("execution(* get*(..))")
	public void AllGetters(){}
	

	@Pointcut("within(org.mursil.spring.practice.model.*)")
	public void AllModels(){}
	
	
	@Before("AllGetters() && AllModels()")
	public void LoggingAdvice(){
		System.out.println("All Getters from Model Classes called.");
		
	}
	
	@Before("AllGetters()")
	public void AnotherLoggingAdvice(JoinPoint joinPoint){
		System.out.println("All Getters Advice called. Pointcut="+joinPoint.toString());
		
	}
	
	
	@Before("args(name)")
	public void SetAdvice(String name){
		System.out.println("SetAdvice Called: "+name);
		
	}
	
	
	
	
	
	
	
	
}
