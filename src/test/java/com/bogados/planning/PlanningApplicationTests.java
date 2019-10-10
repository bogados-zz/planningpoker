package com.bogados.planning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanningApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPasswordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String result = passwordEncoder.encode("Palmeras61212");
		System.out.println(result);
	}

}
