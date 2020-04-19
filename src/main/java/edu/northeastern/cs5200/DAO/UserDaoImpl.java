package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Address;
import edu.northeastern.cs5200.model.User;
import edu.northeastern.cs5200.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

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


  @Override
  @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
  @PostMapping(path = "/api/user/create")
  public User createUser(@RequestBody User user, HttpSession session) {
    session.setAttribute("currentUser", user);
    userRepository.save(user);
    return user;
  }

  @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
  @GetMapping(path = "/api/user/currentUser")
  public User currentUser(HttpSession session) {
    return (User) session.getAttribute("currentUser");
  }


  @CrossOrigin
  @RequestMapping("/api/users/find/all")
  @Override
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }


  @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
  @PostMapping("/api/user/logout")
  public void logout(HttpSession session) {
    session.invalidate();
  }

  @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
  @PostMapping("/api/user/login")
  public User login(@RequestBody User user, HttpSession session) {
    user = userRepository.FindUserByCredentials(user.getUsername(), user.getPass());
    session.setAttribute("currentUser", user);
    return user;
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
