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
 * Customer Entity Class for holding customer's information.
 * 
 * @author Mursil
 *
 */
@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
	
	
	private String name;
	private String emailAddress;
	
	/**
	 *  * Default Constructor for Hibernate
	 */
	public Customer()
	{
		
	}
	/**
	 * * Parametrized Constructor for quick initialization
	 * 
	 * @param name
	 * @param emailAddress
	 */
	public Customer(String name, String emailAddress) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	
	
}
