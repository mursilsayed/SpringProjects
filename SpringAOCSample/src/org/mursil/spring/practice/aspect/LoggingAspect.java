package org.mursil.spring.practice.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	//	System.out.println("SetAdvice Called; Joinpoint= "+join+"; argument="+name);
		System.out.println("SetAdvice Called; argument="+name);
		
	}
	
	
	
	@AfterReturning(pointcut="args(name)",returning="returnedObject")
	public void SetAdvice(String name,String returnedObject){
		System.out.println("SetAdvice Called; Argument= "+name+" ;ReturnedObject= "+returnedObject);
		
	}
	
	@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void SetAdvice(String name,Exception ex){
		System.out.println("SetAdvice Called; Argument= "+name+" ;Exception= "+ex);
		
	}
	
	
	@Around("AllGetters() && AllModels()")
	public Object AroundAdviceTest(ProceedingJoinPoint point)
	{
		Object result =null;
		try {
			System.out.println("AroundAdvice Called before method execution. Method="+point.getSignature());
			
			result = point.proceed();
			
			System.out.println("AroundAdvice Called after method execution. Method="+point.getSignature());
			
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
}
