package com.hbl.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.hbl.SpringRestApplication;
import com.hbl.sample.controller.GreetingController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringRestApplication.class)
@WebIntegrationTest
public class TestGreetingControllerSpringBoot {
	
	@Autowired
    private GreetingController greetingController;
	
	RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void test() {
		
		
		
		
	}
}
