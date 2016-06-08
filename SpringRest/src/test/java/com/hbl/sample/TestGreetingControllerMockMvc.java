package com.hbl.sample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hbl.SpringRestApplication;
import com.hbl.sample.controller.GreetingController;
import com.hbl.sample.service.GreetingService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringRestApplication.class)
@WebAppConfiguration
public class TestGreetingControllerMockMvc {

	
	
	@Autowired
    private GreetingController greetingController;
 
    private MockMvc mockMvc;
    
	@Before
	public void setUp() throws Exception {
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build();
	      
	}

	@Test
	public void test() throws Exception{
		
		   
		this.mockMvc.perform(get("/greeting").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
	            .andExpect(status().isOk())
	            .andDo(print());
		
	 
	}
	
}
