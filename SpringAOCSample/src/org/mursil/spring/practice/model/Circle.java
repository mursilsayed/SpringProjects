package org.mursil.spring.practice.model;

import org.mursil.spring.practice.aspect.Loggable;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String setNameandReturn(String name){
		this.name = name;
		//throw new RuntimeException();
		return name;
	}
	
	@Loggable
	public void MethodUsingCustomAnnotation(){
	
		
	}
	
}
