package com.mursilsayed.sessionobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonRawValue;


@Entity
public class ApplicationParameters implements Serializable{
	
	@Id
	@Column(nullable = false)
    private String paramKey;

	@Lob
	@JsonRawValue
	private String paramValue;
	
	public ApplicationParameters(){
		
	}

	public String getParam_key() {
		return paramKey;
	}

	public void setParam_key(String param_key) {
		this.paramKey = param_key;
	}

	public String getParam_value() {
		return paramValue;
	}

	public void setParam_value(String param_value) {
		this.paramValue = param_value;
	}
	
}
