package edu.northeastern.cs5200.DAO;

import java.util.List;
import java.util.Optional;

import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.User;

public interface UserDao {

  public User createUser(User user);

  public List<User> findAllUsers();

  public User findUserByUserName(String username);

  public Optional<User> findUserByUserId(int userId);

  public void updateUser(int userId, User user);

  public void deleteUser(int userId);

  public void addToWatchList(String movieName);

  public void removerFromWatchList(String movieName);

  public void followUser(String userName);

  public void unFollowUser(String userName);


}


