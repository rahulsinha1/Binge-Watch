package edu.northeastern.cs5200.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public abstract class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;

  private String firstName;

  private String lastName;

  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String pass;

  @Column(unique = true, nullable = false)
  private String email;


  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Phone> phone;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  @JsonIgnore
  private Address address;

  public Person(String firstName, String lastName, String username, String pass, String email, List<Phone> phone, Address address, Role role) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.pass = pass;
    this.email = email;
    if (this.phone != null) {
      this.phone.clear();
    }
    this.phone.addAll(phone);
    this.address = address;
    this.role = role;
  }

  public Person() {
    this.phone = new ArrayList<>();
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

  public void addPhone(Phone phoneToAdd)
  {
    this.phone.add(phoneToAdd);
  }


  public List<Phone> getPhone() {
    return phone;
  }

  public void setPhone(List<Phone> phone) {
    if (this.phone != null) {
      this.phone.clear();
    }
    this.phone.addAll(phone);

  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}


