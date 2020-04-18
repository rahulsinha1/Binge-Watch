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


  public User updateUser(String username, User user);

  public void deleteUser(String username);

  public void addToWatchList(String username, String movieName);

  public void removerFromWatchList(String username,String movieName);

  public void followUser(String followerName, String followedName);

  public void unFollowUser(String followerName, String followedName,String userName);


}


