package com.example.likeherotozero.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;


@Entity
@IdClass(com.example.likeherotozero.entity.IdClass.class)
public class Co2Austoss implements Serializable {

  @Id
  private String country;

  private String code;

  @Id
  private String year;

  private double annualCo2Emissions;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public double getAnnualCo2Emissions() {
    return annualCo2Emissions;
  }

  public void setAnnualCo2Emissions(double annualCo2Emissions) {
    this.annualCo2Emissions = annualCo2Emissions;
  }
}
