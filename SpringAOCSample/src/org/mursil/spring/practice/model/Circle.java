package org.mursil.spring.practice.model;

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
}
