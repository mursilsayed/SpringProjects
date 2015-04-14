package org.mursil.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan()
@EnableAutoConfiguration
public class SpringBootApp  extends SpringBootServletInitializer  {
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringBootApp.class);
	    }

	public static void main(String[] args) {
		System.out.print("Hello World");
		 SpringApplication.run(SpringBootApp.class, args);
	}

}
