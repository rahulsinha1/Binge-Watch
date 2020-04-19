package edu.northeastern.cs5200.DAO;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import edu.northeastern.cs5200.model.Address;
import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.repository.MovieRepository;
import edu.northeastern.cs5200.repository.UserRepository;
import edu.northeastern.cs5200.model.User;

@RestController
public class UserDaoImpl implements UserDao {


  @Autowired
  UserRepository userRepository;
  @Autowired
  MovieRepository movieRepository;

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
  public User updateUser(@PathVariable("username") String username, @RequestBody User user) {
    return null;
  }

  @RequestMapping("/api/user/delete/{username}")
  @CrossOrigin
  @Override
  public void deleteUser(@PathVariable("username") String username) {
    User user = findUserByUserName(username);
    userRepository.delete(user);

  }

  @RequestMapping("/api/user/add/watchlist/{username}/{movie}")
  @CrossOrigin
  @Override
  public void addToWatchList(@PathVariable("username") String username, @PathVariable("movie") String movieName) {
    User user = findUserByUserName(username);
    Movie movie = movieRepository.findFromDB(movieName);
    user.getWatchList().add(movie);
    userRepository.save(user);

  }

  @RequestMapping("/api/user/remove/watchlist/{username}/{movie}")
  @CrossOrigin
  @Override
  public void removerFromWatchList(@PathVariable("username") String username, @PathVariable("movie") String movieName) {
    User user = findUserByUserName(username);
    System.out.println(user.getUsername());
    Movie movie = movieRepository.findFromDB(movieName);
    System.out.println(user.getWatchList().get(0).getName());
    user.getWatchList().remove(movie);
    userRepository.save(user);
  }

  @CrossOrigin
  @RequestMapping("/api/user/follow/{follower}/{followed}")
  public void followUser(@PathVariable("follower") String followerName, @PathVariable("followed") String followedName) {
    User follower = findUserByUserName(followerName);
    User followed = findUserByUserName(followedName);
    followed.addFollower(follower);
    userRepository.save(follower);
    userRepository.save(followed);


  }

  @CrossOrigin
  @RequestMapping("/api/user/unfollow/{follower}/{followed}")
  public void unFollowUser(@PathVariable("follower") String followerName, @PathVariable("followed") String followedName) {
    User follower = findUserByUserName(followerName);
    User followed = findUserByUserName(followedName);
    followed.removeFollower(follower);
    userRepository.save(follower);
    userRepository.save(followed);
  }

  @CrossOrigin
  @RequestMapping("/api/user/get/followers/{username}")
  @Override
  public List<User> getFollowersByUserName(@PathVariable("username") String username) {
    User user = userRepository.findByUserName(username);
    return user.getFollowers();
  }

  @CrossOrigin
  @RequestMapping("/api/user/get/following/{username}")
  @Override
  public List<User> getFollowingByUserName(@PathVariable("username") String username) {
    User user = userRepository.findByUserName(username);
    return user.getFollowing();
  }

  @CrossOrigin
  @RequestMapping("/api/user/get/watchlist/{username}")
  @Override
  public List<Movie> getWatchlistByUserName(@PathVariable("username") String username) {
    User user = userRepository.findByUserName(username);
    if (user != null) {
      return user.getWatchList();
    }
    return null;

  }


  @RequestMapping("/api/user/get/streamingDetails/")
  public Response getStreamingDetails() {


    return null;
  }
}
