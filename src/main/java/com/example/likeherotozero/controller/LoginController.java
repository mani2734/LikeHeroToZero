package com.example.likeherotozero.controller;

import com.example.likeherotozero.CurrentUser;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LoginController {
  @Inject CurrentUser currentUser;


  private static final String adminUser = "admin";
  private static final String adminPassword = "admin";

  String failureMessage = "";

  String tmpUser;
  String tmpPassword;


  public String login() {
    if (currentUser.isAdmin() || currentUser.isGuest()) {
      return "index.xhtml?faces-redirect=true";
    } else {
      this.failureMessage = "Benutzer nicht eingelogt";
      return "";
    }
  }

  private boolean checkUsernamePassword() {
    if(!tmpUser.equals(adminUser) || !tmpPassword.equals(adminPassword)) {
      return false;
    }
    return true;
  }

  public void validateLogin() {
    if (checkUsernamePassword())
      throw new ValidatorException(new FacesMessage("Login falsch!"));
  }
}
