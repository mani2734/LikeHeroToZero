package com.example.likeherotozero.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IdClass implements Serializable {
  private String country;
  private String year_;

  public IdClass() {

  }

  public IdClass(String country, String year_) {
    this.country = country;
    this.year_ = year_;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o instanceof IdClass) {
      return Objects.equals(((IdClass) o).country, this.country) && Objects.equals(((IdClass) o).year_, this.year_);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, year_);
  }
}
