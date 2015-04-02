package org.mursil.spring.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class Circle implements Shape {

	private Point centre;
	
	public Point getCentre() {
		return centre;
	}

	//@Autowired
	//@Qualifier("circleRelated")
	@Resource
	public void setCentre(Point centre) {
		this.centre = centre;
	}

	@Override
	public void draw() {
		System.out.println(centre);
		
	}
	
	@PreDestroy
	public void onDestroy()  {
		System.out.println("Circle: @PreDestroy");
		
	}
	

	@PostConstruct
	public void OnInitCircle() 
	{
		System.out.println("Circle: @PostConstruct");
	}
	
	

}
