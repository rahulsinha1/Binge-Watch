package edu.northeastern.cs5200.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public abstract class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;

  private String firstName;

  private String lastName;

  @Column(unique = true)
  private String username;

  private String pass;

  @Column(unique = true)
  private String email;


  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Phone> phone;

  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Address> address;

  public Person(String firstName, String lastName, String username, String pass, String email, List<Phone> phone, List<Address> address, Role role) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.pass = pass;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.role = role;
  }

  public Person() {
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Enumerated(EnumType.STRING)
  private Role role;

  public Person(String username, String pass) {
    this.username = username;
    this.pass = pass;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public List<Phone> getPhone() {
    return phone;
  }

  public void setPhone(List<Phone> phone) {
    this.phone = phone;
  }

  public List<Address> getAddress() {
    return address;
  }

  public void setAddress(List<Address> address) {
    this.address = address;
  }
}


