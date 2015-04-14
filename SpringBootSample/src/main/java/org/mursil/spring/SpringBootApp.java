package org.mursil.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan()
@EnableAutoConfiguration
public class SpringBootApp {

	public static void main(String[] args) {
		System.out.print("Hello World");
		 SpringApplication.run(SpringBootApp.class, args);
	}

}
