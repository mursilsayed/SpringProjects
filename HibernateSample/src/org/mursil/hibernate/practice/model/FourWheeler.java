package org.mursil.hibernate.practice.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="Car")
public class FourWheeler extends Vehicle {

	private String steeringWheel="Default Wheel";

	public FourWheeler(){}
	public FourWheeler(String name,int id){
		super(name,id);
		
	}

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
