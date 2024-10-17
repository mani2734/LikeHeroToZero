package com.example.likeherotozero.entity;

import java.io.Serializable;
import java.util.Objects;

public class IdClass implements Serializable {

  private String country;
  private String year;

  public IdClass(String country, String year) {
    this.country = country;
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IdClass idClass)) {
      return false;
    }
    return Objects.equals(country, idClass.country) && Objects.equals(year, idClass.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, year);
  }
}
