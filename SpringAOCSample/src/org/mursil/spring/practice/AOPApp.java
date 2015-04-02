package org.mursil.spring.practice;

import org.mursil.spring.practice.model.Circle;
import org.mursil.spring.practice.service.ShapeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPApp {

	public static void main(String[] args) {
	

		AbstractApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		System.out.println(context.getBean("shapeService",ShapeService.class).getCircle().getName());
		
		
	}

}
