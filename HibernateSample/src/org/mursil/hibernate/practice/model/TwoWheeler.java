package org.mursil.hibernate.practice.model;


import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="Bike")
public class TwoWheeler extends Vehicle {

	private String SteeringHandle="Default Handle";
	
	public TwoWheeler(){}
	public TwoWheeler(String name){
		super(name);
		
	}

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
	
}
