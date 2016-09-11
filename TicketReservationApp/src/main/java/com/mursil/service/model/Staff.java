/**
 * 
 */
package com.mursil.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Staff Entity holding Airline Staff Details
 * @author Mursil
 *
 */
@Entity
public class Staff {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
	
	@Column(nullable =false)
	private String name;

	/**
	 *  Parametrized Constructor for quick initialization
	 * @param name
	 */
	public Staff(String name) {
		super();
		this.name = name;
	}
	
	
	/**
	 * Default Constructor for Hibernate
	 */
	public Staff(){
		
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
