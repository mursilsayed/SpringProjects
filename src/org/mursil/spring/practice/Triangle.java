package org.mursil.spring.practice;

import java.util.List;

import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape,ApplicationContextAware,BeanNameAware,DisposableBean,InitializingBean{

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
	
//	private Point point1;
//	private Point point2;
//	private Point point3;
//	
//	
//	
//	public Point getPoint1() {
//		return point1;
//	}
//
//
//
//	public void setPoint1(Point point1) {
//		this.point1 = point1;
//	}
//
//
//
//	public Point getPoint2() {
//		return point2;
//	}
//
//
//
//	public void setPoint2(Point point2) {
//		this.point2 = point2;
//	}
//
//
//
//	public Point getPoint3() {
//		return point3;
//	}
//
//
//
//	public void setPoint3(Point point3) {
//		this.point3 = point3;
//	}
//
//
//
//	public void draw(){
//		System.out.println( " Triangle Drawn ");
//		System.out.println("Point1:"+point1);
//		System.out.println("Point1:"+point2);
//		System.out.println("Point1:"+point3);
//		
//		
//	}
	
	private List<Point> list;
	private ApplicationContext context=null;

	@Required
	public List<Point> getList() {
		return list;
	}

	@Required
	public void setList(List<Point> list) {
		this.list = list;
	}
	
	@Override
	public void draw(){
		for(Point p:list){
			
			System.out.println(p);
		}
		
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context= context;
		
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name:"+beanName);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Triangle:OnDestroy");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("Triangle:Init-afterPropertiesSet");
	}
	
	
	
	public void onDestroy()  {
		System.out.println("Triangle:Custom onDestroy");
		
	}
	
	public void OnInit() 
	{
		System.out.println("Triangle:Custom OnInit");
	}
	
	@PreDestroy
	public void onDestroy2()  {
		System.out.println("Triangle: @PreDestroy");
		
	}
	
}
