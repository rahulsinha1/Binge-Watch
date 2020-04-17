package edu.northeastern.cs5200.DAO;

import java.util.List;

import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.User;

public interface UserDao {

  public void createUser(User user);

  public List<User> findAllUsers();

  public User findUserByUserName(String username);

  public User findUserByUserId(int userId);

  public void updateUser(int userId, User user);

  public void deleteUser(int userId);

  public boolean authorizeUserLogin();

  public void addToWatchList(String movieName);

  public void removerFromWatchList(String movieName);

  public void followUser(String userName);

  public void unFollowUser(String userName);



}
