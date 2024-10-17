package com.example.likeherotozero.controller;

import com.example.likeherotozero.dao.Co2AustossDAO;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class Co2AustossController implements Serializable {

  @Inject
  public Co2AustossDAO co2AustossDAO;



}
