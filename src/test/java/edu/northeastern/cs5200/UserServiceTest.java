package edu.northeastern.cs5200;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.controllers.user.UserRepository;

class UserServiceTest {

	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	void test() {
		
	}

}
