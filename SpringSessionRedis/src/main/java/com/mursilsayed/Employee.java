package com.mursilsayed;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee extends HashMap<String,String>{

	private @Id @GeneratedValue Long id;
//	private final String firstName, lastName, title;

	Employee() {
//		this.firstName = null;
//		this.lastName = null;
//		this.title = null;
	}
	
	Employee(String firstName, String lastName, String title) {
		this.put("firstName", firstName);
		this.put("lastName", lastName);
		this.put("title", title);
		
		
		
	}
	
	
	@Override
	public String toString()
	{
		return (String)this.get("firstName");
		
	}
}