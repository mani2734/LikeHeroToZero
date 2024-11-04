package com.example.likeherotozero.controller;

import com.example.likeherotozero.dao.Co2AustossDAO;
import com.example.likeherotozero.entity.Co2Austoss;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class Co2AustossController implements Serializable {

  private Co2AustossDAO co2AustossDAO = new Co2AustossDAO();


  public List<Co2Austoss> getAll() {
    return this.co2AustossDAO.getAll();
  }

  public Co2Austoss getNewestEntryForCountry(String country) {
    return this.co2AustossDAO.getNewestEntryForCountry(country);
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

}
