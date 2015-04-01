package org.mursil.spring.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {

	private Point centre;
	
	public Point getCentre() {
		return centre;
	}

	@Autowired
	@Qualifier("circleRelated")
	public void setCentre(Point centre) {
		this.centre = centre;
	}

	@Override
	public void draw() {
		System.out.println(centre);
		
	}

}
