package edu.northeastern.cs5200.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Address {


  public Address() {
    streetAddress = "";
    city = "";
    state = "";
    country ="";
    zipCode = "";

  }

  public Address(String streetAddress, String city, String state, String zipCode, String country) {
    this.streetAddress = streetAddress;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.country = country;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;
  private String streetAddress;
  private String city;
  private String state;
  private String zipCode;
  private String country;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @OneToOne(mappedBy = "address")
  private User user;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}


