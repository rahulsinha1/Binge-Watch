package edu.northeastern.cs5200.controllers.user;

import java.util.List;

public class User extends Person {

  private List<User> followers;
  private List<User> following;
  private List<Movie> watchList;

}
