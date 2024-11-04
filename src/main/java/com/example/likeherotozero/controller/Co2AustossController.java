package com.example.likeherotozero.controller;

import com.example.likeherotozero.dao.Co2AustossDAO;
import com.example.likeherotozero.entity.Co2Austoss;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Named
@ApplicationScoped
public class Co2AustossController implements Serializable {


  private Co2AustossDAO co2AustossDAO = new Co2AustossDAO();

  private List<Co2Austoss> lst;

  @PostConstruct
  private void initializeLst() {
    if(lst == null) {
      this.lst = getAll();
    }
  }

  private Co2Austoss newestEntry;



  public Set<String> getCountries() {
    return this.co2AustossDAO.getCountries();
  }

  public List<Co2Austoss> getAll() {
    return this.co2AustossDAO.getAll();
  }

  public void getNewestEntryForCountry(String country) {
    this.newestEntry = this.co2AustossDAO.getNewestEntryForCountry(country);
  }

  public boolean addEntry(Co2Austoss co2Austoss) {
    try {
      this.co2AustossDAO.persist(co2Austoss);
    } catch(Exception e) {
      System.out.println("Couldn't add entry");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public List<Co2Austoss> getLst() {
    return lst;
  }

  public void setLst(List<Co2Austoss> lst) {
    this.lst = lst;
  }

  public Co2Austoss getNewestEntry() {
    return newestEntry;
  }

  public void setNewestEntry(Co2Austoss newestEntry) {
    this.newestEntry = newestEntry;
  }
}
