package edu.northeastern.cs5200.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.List;

@Entity
public class User extends Person {

  public User(int id, String firstName, String lastName, String username, String pass, String email, List<Phone> phone, Address address, Role role) {
    super(firstName, lastName, username, pass, email, phone, address, role);
  }

  public User() {
  }


  public List<User> getFollowers() {
    return followers;
  }

  public void setFollowers(List<User> followers) {
    this.followers = followers;
  }

  public List<User> getFollowing() {
    return following;
  }

  public void setFollowing(List<User> following) {
    this.following = following;
  }

  public List<Movie> getWatchList() {
    return watchList;
  }

  public void setWatchList(List<Movie> watchList) {
    this.watchList = watchList;
  }

  public void addFollower(User follower) {
    followers.add(follower);
    follower.following.add(this);
  }

  public void removeFollower(User follower) {
    followers.remove(follower);
    follower.following.remove(this);
  }


  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
  @JoinTable(name = "USER_RELATIONS",
          joinColumns = @JoinColumn(name = "FOLLOWED_ID"),
          inverseJoinColumns = @JoinColumn(name = "FOLLOWER_ID"))
  @JsonIgnore
  private List<User> followers;

  @JsonIgnore
  @ManyToMany(mappedBy = "followers", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
  private List<User> following;

  @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
  @JoinTable(name = "watchlist",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "movie_id"))
  private List<Movie> watchList;

  public User(String username, String pass) {
    super(username, pass);
  }
}
