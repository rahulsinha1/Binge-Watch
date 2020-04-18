package edu.northeastern.cs5200.DAO;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

import edu.northeastern.cs5200.model.Address;
import edu.northeastern.cs5200.repository.UserRepository;
import edu.northeastern.cs5200.model.User;

@RestController
public class UserDaoImpl implements UserDao {


  @Autowired
  UserRepository userRepository;

  @CrossOrigin
  @RequestMapping("/api/user/description")
  public User sayUserObject() {
    User user = new User("test", "password");
    user.setAddress(new Address());
    return user;
  }


  @CrossOrigin
  @RequestMapping("/api/user/insert/{username}/{pass}")
  public User insertUser(@PathVariable("username") String user, @PathVariable("pass") String pass) {
    User userObj = new User(user, pass);
    userRepository.save(userObj);
    return userObj;
  }

  @CrossOrigin
  @RequestMapping("/api/users/select/all")
  public List<User> selectAllUserObjects() {
    List<User> users =
            (List<User>) userRepository.findAll();
    return users;
  }


  @CrossOrigin
  @PostMapping(path = "/api/user/create", consumes = "application/json", produces = "application/json")
  @Override
  public User createUser(@RequestBody User user) {
    userRepository.save(user);
    return user;
  }

  @CrossOrigin
  @RequestMapping("/api/users/find/all")
  @Override
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }


  @CrossOrigin
  @RequestMapping("/api/user/find/username/{username}")
  @Override
  public User findUserByUserName(@PathVariable("username") String username) {
    return userRepository.findByUserName(username);
  }

  @RequestMapping("/api/user/find/id/{userId}")
  @Override
  public Optional<User> findUserByUserId(@PathVariable("userId") int userId) {
    return userRepository.findById(userId);
  }

  @CrossOrigin
  @Override
  @PostMapping(path = "/api/user/update/{username}", consumes = "application/json", produces = "application/json")
  public User updateUser(@PathVariable("username") String username,@RequestBody User user ) {
    return null;
  }

  @RequestMapping("/api/user/delete/{username}")
  @CrossOrigin
  @Override
  public void deleteUser(@PathVariable("username") String username) {
    User user = findUserByUserName(username);
    userRepository.delete(user);

  }

  @CrossOrigin
  @Override
  public void addToWatchList(String username, String movieName) {

  }

  @CrossOrigin
  @Override
  public void removerFromWatchList(String username, String movieName) {

  }

  @CrossOrigin
  @Override
  public void followUser(String followerName, String followedName) {

  }

  @CrossOrigin
  @Override
  public void unFollowUser(String followerName, String followedName, String userName) {

  }


}
