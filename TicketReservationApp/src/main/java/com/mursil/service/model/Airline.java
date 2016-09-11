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
 * Airline Entity 
 * 
 * @author Mursil
 *
 */
@Entity
public class Airline {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
	
	private String name;

	
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
