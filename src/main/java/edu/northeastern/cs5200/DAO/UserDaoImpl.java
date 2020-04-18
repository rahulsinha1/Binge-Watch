package edu.northeastern.cs5200.DAO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.repository.UserRepository;
import edu.northeastern.cs5200.model.User;

@RestController
public class UserDaoImpl implements UserDao {
	

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


  @PostMapping(path = "/api/user/create", consumes = "application/json", produces = "application/json")
  @Override
  public User createUser(@RequestBody User user) {
	  userRepository.save(user);
	  return user;
  }

  @RequestMapping("/api/users/find/all")
  @Override
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }


  @RequestMapping("/api/user/find/{username}")
  @Override
  public User findUserByUserName(@PathVariable("username") String username) {
   return userRepository.findByUserName(username);
  }

  @Override
  public Optional<User> findUserByUserId(int userId) {
    return userRepository.findById(userId);
  }

  @Override
  public void updateUser(int userId, User user) {


  }

  @Override
  public void deleteUser(int userId) {

  }

  @Override
  public void addToWatchList(String movieName) {

  }

  @Override
  public void removerFromWatchList(String movieName) {

  }

  @Override
  public void followUser(String userName) {

  }

  @Override
  public void unFollowUser(String userName) {

  }
}
