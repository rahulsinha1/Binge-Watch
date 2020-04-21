//package edu.northeastern.cs5200.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//
//@Entity
//public class User extends Person {
//
//  public List<User> getFollowers() {
//    return followers;
//  }
//
//  public void setFollowers(List<User> followers) {
//    this.followers = followers;
//  }
//
//  public List<User> getFollowing() {
//    return following;
//  }
//
//  public void setFollowing(List<User> following) {
//    this.following = following;
//  }
//
//  public List<Movie> getWatchList() {
//    return watchList;
//  }
//
//  public void setWatchList(List<Movie> watchList) {
//    this.watchList = watchList;
//  }
//
//
//  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//  @JoinTable(name = "USER_RELATIONS",
//          joinColumns = @JoinColumn(name = "FOLLOWED_ID"),
//          inverseJoinColumns = @JoinColumn(name = "FOLLOWER_ID"))
//  @JsonIgnore
//  private List<User> followers;
//
//  @JsonIgnore
//  @ManyToMany(mappedBy = "followers", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
//  private List<User> following;
//
//  @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
//  @JoinTable(name = "watchlist",
//          joinColumns = @JoinColumn(name = "user_id"),
//          inverseJoinColumns = @JoinColumn(name = "movie_id"))
//  @JsonIgnore
//  private List<Movie> watchList;
//
//  public User(String username, String pass) {
//    super(username, pass);
//  }
//}
