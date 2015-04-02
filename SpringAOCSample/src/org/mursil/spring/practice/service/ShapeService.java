package org.mursil.spring.practice.service;

import javax.annotation.Resource;

import org.mursil.spring.practice.model.Circle;
import org.mursil.spring.practice.model.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class ShapeService {

	@Autowired
	@Qualifier("circle")
	private Circle circle;
	@Resource
	private Triangle triangle;
	
	
	
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

	
	
}
