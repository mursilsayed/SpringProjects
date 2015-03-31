package org.mursil.spring.practice;

public class Triangle {

	private String type;
	
	public void draw(){
		
		System.out.println(this.getType()+ " Triangle Drawn");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
