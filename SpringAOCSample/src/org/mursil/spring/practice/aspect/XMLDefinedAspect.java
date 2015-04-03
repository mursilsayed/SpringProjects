package org.mursil.spring.practice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;


public class XMLDefinedAspect {

	//@Around("@annotation(org.mursil.spring.practice.aspect.Loggable)")
	public Object AroundAdviceWithXML(ProceedingJoinPoint point)
	{
		Object result =null;
		try {
			System.out.println("AroundAdvicewithXML Called before method execution. Method="+point.getSignature());
			
			result = point.proceed();
			
			System.out.println("AroundAdvicewithXML Called after method execution. Method="+point.getSignature());
			
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		return result;
	}
}
