package edu.northeastern.cs5200.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;
}
