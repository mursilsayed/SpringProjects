package com.mursil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringRedisJmxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisJmxApplication.class, args);
	}
}
