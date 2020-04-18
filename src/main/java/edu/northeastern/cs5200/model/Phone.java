package edu.northeastern.cs5200.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Phone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;
  private long number;
  private boolean isPrimary;

  public Phone(long number, boolean isPrimary) {
    this.number = number;
    this.isPrimary = isPrimary;
  }

  public Phone() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }

  public boolean isPrimary() {
    return isPrimary;
  }

  public void setPrimary(boolean primary) {
    isPrimary = primary;
  }
}

