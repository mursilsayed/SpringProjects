package org.mursil.hibernate.practice.model;

import javax.persistence.Entity;


public class Circle {

	
	private int Id;
	private String name;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
