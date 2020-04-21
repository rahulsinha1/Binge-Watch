package edu.northeastern.cs5200.DAO;


import edu.northeastern.cs5200.model.Address;
import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.Phone;
import edu.northeastern.cs5200.model.Role;
import edu.northeastern.cs5200.model.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

public interface UserDao {

  public User createUser(User user, HttpSession session);

  public List<User> findAllUsers();

  public User findUserByUserName(String username);

  public Optional<User> findUserByUserId(int userId);

  public User currentUser(HttpSession session);

  public void logout(HttpSession session);

  public User login(User user, HttpSession session);

  public User updateUser(String username, User user);

  public void deleteUser(String username);

  public void addToWatchList(String username, String movieName);

  public void removerFromWatchList(String username, String movieName);

  public void followUser(String followerName, String followedName);

  public void unFollowUser(String followerName, String followedName);

  public List<User> getFollowersByUserName( String username);

  public List<User> getFollowingByUserName( String username);

  public List<Movie> getWatchlistByUserName(String username);

  public User addPhone(String username, Phone phone);

  public User removePhone(String username, Phone phone);

  public User addAddress(String username, Address address);

  public User updateRole(String userName, Role role);


}


