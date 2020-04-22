package edu.northeastern.cs5200.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Critic extends Person {

  private String company;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  @Fetch(FetchMode.SUBSELECT)
  private List<MovieReview> movieReviews;

  public Critic() {
    this.movieReviews = new ArrayList<>();
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public List<MovieReview> getMovieReviews() {
    return movieReviews;
  }

  public void setMovieReviews(List<MovieReview> movieReviews) {
    this.movieReviews = movieReviews;
  }

  public Critic(String firstName, String lastName, String username, String pass, String email, List<Phone> phone, Address address, Role role, String company) {
    super(firstName, lastName, username, pass, email, phone, address, role);
    this.company = company;
    this.movieReviews = new ArrayList<>();
  }
}
