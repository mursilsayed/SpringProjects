package org.mursil.spring.practice;

public class Triangle {

//	private String type;
//	private int height;
//	public int getHeight() {
//		return height;
//	}
//	public Triangle(String type){
//		
//		this.type = type;
//	}
//    public Triangle(String type, int height){
//		
//		this.type = type;
//		this.height= height;
//	}
//	
//	public void draw(){
//		
//		System.out.println(this.getType()+ " Triangle Drawn with height "+this.getHeight());
//	}
//
//	public String getType() {
//		return type;
//	}

//	public void setType(String type) {
//		this.type = type;
//	}
	
	private Point point1;
	private Point point2;
	private Point point3;
	
	
	
	public Point getPoint1() {
		return point1;
	}



	public void setPoint1(Point point1) {
		this.point1 = point1;
	}



	public Point getPoint2() {
		return point2;
	}



	public void setPoint2(Point point2) {
		this.point2 = point2;
	}



	public Point getPoint3() {
		return point3;
	}



	public void setPoint3(Point point3) {
		this.point3 = point3;
	}



	public void draw(){
		System.out.println( " Triangle Drawn ");
		System.out.println("Point1:"+point1);
		System.out.println("Point1:"+point2);
		System.out.println("Point1:"+point3);
		
		
	}
	
}
