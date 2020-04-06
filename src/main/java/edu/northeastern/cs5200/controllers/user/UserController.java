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
	public UserObject sayUserObject() {
		UserObject user = new UserObject("test","password");
		return user;
	}

	



@RequestMapping("/api/user/insert/{username}/{pass}")
public UserObject insertUser(@PathVariable("username") String user,@PathVariable("pass") String pass ) {
	UserObject userObj = new UserObject(user,pass);
	userRepository.save(userObj);
	return userObj;
}

@RequestMapping("/api/users/select/all")
public List<UserObject> selectAllUserObjects() {
	List<UserObject> users =
		(List<UserObject>)userRepository.findAll();
	return users;
}



}
