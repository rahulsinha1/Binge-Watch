package edu.northeastern.cs5200.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity

public class Critic extends Person {

  private String company;

  @OneToMany(mappedBy = "critic",fetch = FetchType.EAGER)
  @Fetch(FetchMode.SUBSELECT)
  private List<MovieReview> movieReviews;

  public Critic() {
    this.movieReviews = new ArrayList<>();
  }

  public Critic(String firstName, String lastName, String username, String pass, String email, List<Phone> phone, Address address, Role role, String company) {
    super(firstName, lastName, username, pass, email, phone, address, role);
    this.company = company;
    this.movieReviews = new ArrayList<>();
  }
}
