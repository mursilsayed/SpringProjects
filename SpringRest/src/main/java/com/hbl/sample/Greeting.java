package com.hbl.sample;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Greeting extends ResourceSupport {

	 private final String content;

	    @JsonCreator
	    public Greeting( String content) {
	        this.content = content;
	    }

	    public String getContent() {
	        return content;
	    }
}
