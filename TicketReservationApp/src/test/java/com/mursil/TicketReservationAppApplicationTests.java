package com.mursil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mursil.TicketReservationAppApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketReservationAppApplication.class)
@WebAppConfiguration
public class TicketReservationAppApplicationTests {

	@Test
	public void contextLoads() {
	}

}
