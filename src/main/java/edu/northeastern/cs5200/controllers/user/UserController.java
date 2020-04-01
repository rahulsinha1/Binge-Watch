package edu.northeastern.cs5200.controllers.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping("/api/user/description")
	public UserObject sayUserObject() {
		UserObject user = new UserObject("test","password");
		return user;
	}

}
