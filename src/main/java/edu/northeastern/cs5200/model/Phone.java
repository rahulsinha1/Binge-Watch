package edu.northeastern.cs5200.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "number")
)

public class Phone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;
  @Column(unique = true)
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

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Phone))
      return false;

    Phone phone = (Phone) obj;
    return phone.number == this.number;
  }
}

