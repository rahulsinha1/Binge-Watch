package edu.northeastern.cs5200.controllers.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {
	

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/api/user/description")
	public User sayUserObject() {
		User user = new User("test","password");
		return user;
	}

	



@RequestMapping("/api/user/insert/{username}/{pass}")
public User insertUser(@PathVariable("username") String user,@PathVariable("pass") String pass ) {
	User userObj = new User(user,pass);
	userRepository.save(userObj);
	return userObj;
}

@RequestMapping("/api/users/select/all")
public List<User> selectAllUserObjects() {
	List<User> users =
		(List<User>)userRepository.findAll();
	return users;
}



}
