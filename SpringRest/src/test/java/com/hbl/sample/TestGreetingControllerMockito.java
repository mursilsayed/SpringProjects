package com.hbl.sample;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.hbl.sample.controller.GreetingController;
import com.hbl.sample.service.GreetingService;

@RunWith(MockitoJUnitRunner.class)
public class TestGreetingControllerMockito {


	@Mock
	private GreetingService greetingService;
	
	@InjectMocks
    private GreetingController greetingController;
 
    private MockMvc mockMvc;
    
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build();
	      
	}

	@Test
	public void test() throws Exception{
		
		Mockito.when(greetingService.getStartupGreeting("Mursil Sayed")).thenReturn(new Greeting("Hello World, Mursil Sayed"));
	       
		this.mockMvc.perform(get("/greeting").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
	            .andExpect(status().isOk())
	            .andDo(print());
		
	 
	}
	
		

}
