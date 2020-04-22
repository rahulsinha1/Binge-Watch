package edu.northeastern.cs5200.DAO;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import edu.northeastern.cs5200.model.*;
import edu.northeastern.cs5200.repository.MovieReviewRepository;
import edu.northeastern.cs5200.repository.MovieRepository;
import edu.northeastern.cs5200.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserDaoImpl implements UserDao {


  @Autowired
  UserRepository userRepository;
  @Autowired
  MovieRepository movieRepository;
  @Autowired
  MovieReviewRepository movieReviewRepository;

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
  public User updateUser(@PathVariable("username") String username, @RequestBody User user) {
    User toUpdate = userRepository.findByUserName(username);
    toUpdate.setAddress(user.getAddress());
    toUpdate.setPhone(user.getPhone());
    userRepository.save(toUpdate);
    userRepository.updateUser(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPass(),username);
    return toUpdate;
  }

  @RequestMapping(path = "/api/user/addPhone/{username}",consumes = "application/json", produces = "application/json")
  @CrossOrigin
  @Override
  public User addPhone(@PathVariable("username") String username, @RequestBody Phone phone)
  {
    User toUpdate = userRepository.findByUserName(username);
    toUpdate.addPhone(phone);
    userRepository.save(toUpdate);
    return toUpdate;
  }

  @RequestMapping(path = "/api/user/removePhone/{username}",consumes = "application/json", produces = "application/json")
  @CrossOrigin
  @Override
  public User removePhone(@PathVariable("username") String username, @RequestBody Phone phone)
  {
    User toUpdate = userRepository.findByUserName(username);
    System.out.println(toUpdate.getPhone().get(0).getNumber());
    toUpdate.getPhone().remove(phone);
    userRepository.save(toUpdate);
    return toUpdate;
  }

  @RequestMapping(path = "/api/user/addAddress/{username}",consumes = "application/json", produces = "application/json")
  @CrossOrigin
  @Override
  public User addAddress(@PathVariable("username") String username, @RequestBody Address address)
  {
    User toUpdate = userRepository.findByUserName(username);
    toUpdate.setAddress(address);
    userRepository.save(toUpdate);
    return toUpdate;
  }

  @RequestMapping("/api/user/updateRole/{username}/{role}")
  @CrossOrigin
  @Override
  public User updateRole(@PathVariable("username") String username, @PathVariable("role") Role role) {
    User user = findUserByUserName(username);
    user.setRole(role);
    userRepository.save(user);
    return user;
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
  public String getStreamingDetails() {
    OkHttpClient client = new OkHttpClient();
    Response response = null;
    String res ="";
    Request request = new Request.Builder()
            .url("https://utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com/lookup?term=aquarius&country=us")
            .get()
            .addHeader("x-rapidapi-host", "utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "c47aad3ae8mshe01fe4ddc4771c7p14d6a3jsn9de6d24820a9")
            .build();

    try {
      response = client.newCall(request).execute();
      res = (response.toString()+"\n"+response.body().string());
    } catch (IOException e) {
      e.printStackTrace();
    }


return res;
  }


}
