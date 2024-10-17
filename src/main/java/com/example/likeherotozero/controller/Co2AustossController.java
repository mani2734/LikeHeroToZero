package com.example.likeherotozero.controller;

import com.example.likeherotozero.dao.Co2AustossDAO;
import com.example.likeherotozero.entity.Co2Austoss;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class Co2AustossController implements Serializable {

  @Inject
  public Co2AustossDAO co2AustossDAO;



  public Co2Austoss getNewestEntryForCountry(String country) {

    return null;
  }

  public boolean addEntry(Co2Austoss co2Austoss) {
    try {
      //save
    } catch(Exception e) {
      System.out.println("Couldn't add entry");
      e.printStackTrace();
      return false;
    }
    return true;
  }

}
