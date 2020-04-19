package edu.northeastern.cs5200.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "watchlist", uniqueConstraints =
@UniqueConstraint(columnNames = {"movie_id", "user_id"}))
public class WatchList {

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getMovie_id() {
    return movie_id;
  }

  public void setMovie_id(int movie_id) {
    this.movie_id = movie_id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int user_id;
  private int movie_id;

  public WatchList(int user_id, int movie_id) {
    this.user_id = user_id;
    this.movie_id = movie_id;
  }
}
