package org.mursil.spring.practice;

public class Triangle {

	private String type;
	private int height;
	public int getHeight() {
		return height;
	}
	public Triangle(String type){
		
		this.type = type;
	}
    public Triangle(String type, int height){
		
		this.type = type;
		this.height= height;
	}
	
	public void draw(){
		
		System.out.println(this.getType()+ " Triangle Drawn with height "+this.getHeight());
	}

	public String getType() {
		return type;
	}

//	public void setType(String type) {
//		this.type = type;
//	}
}
