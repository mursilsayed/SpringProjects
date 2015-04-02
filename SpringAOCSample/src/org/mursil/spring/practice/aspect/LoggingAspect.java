package org.mursil.spring.practice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAspect {

	@Before("execution(public String getName())")
	public void LoggingAdvice(){
		System.out.println("Logging Advice called.");
		
	}
	
}
