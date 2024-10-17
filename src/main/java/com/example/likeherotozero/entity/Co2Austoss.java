package com.example.likeherotozero.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;


@Entity(name = "emissions")
@IdClass(com.example.likeherotozero.entity.IdClass.class)
public class Co2Austoss implements Serializable {

  @Id
  private String country;

  private String code;

  @Id
  private String year_;

  private double co2_emissions;

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

  public String getYear_() {
    return year_;
  }

  public void setYear_(String year_) {
    this.year_ = year_;
  }

  public double getco2_emissions() {
    return co2_emissions;
  }

  public void setco2_emissions(double co2_emissions) {
    this.co2_emissions = co2_emissions;
  }

  @Override
  public String toString() {
    return "Co2Austoss{" + "country='" + country + '\'' + ", code='" + code + '\'' + ", year_='" + year_ + '\'' + ", co2_emissions=" + co2_emissions + '}';
  }
}
