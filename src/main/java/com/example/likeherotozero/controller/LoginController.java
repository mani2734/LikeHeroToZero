package com.example.likeherotozero.controller;

import com.example.likeherotozero.CurrentUser;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {
  @Inject CurrentUser currentUser;

  private static final String adminUser = "admin";
  private static final String adminPassword = "admin";

  private static final String guestUser = "guest";
  private static final String guestPassword = "guest";

  private String failureMessage;

  private String tmpUser;
  private String tmpPassword;

  public String getTmpUser() {
    return tmpUser;
  }

  public void setTmpUser(String tmpUser) {
    this.tmpUser = tmpUser;
  }

  public String getTmpPassword() {
    return tmpPassword;
  }

  public void setTmpPassword(String tmpPassword) {
    this.tmpPassword = tmpPassword;
  }

  public String getFailureMessage() {
    return failureMessage;
  }

  public void setFailureMessage(String failureMessage) {
    this.failureMessage = failureMessage;
  }

  public boolean isAdmin() {
    return this.currentUser.isAdmin();
  }

  private boolean checkUsernamePassword() {
    this.currentUser.reset();
    if(tmpUser.equals(adminUser) && tmpPassword.equals(adminPassword)) {
      this.currentUser.setAdmin(true);
    }
    if(this.tmpUser.equals(guestUser) && tmpPassword.equals(guestPassword)) {
      this.currentUser.setGuest(true);
    }
    if(this.currentUser.isAdmin() || this.currentUser.isGuest()) {
      return true;
    }
    return false;
  }

  public void validateLogin() {
    if (!checkUsernamePassword())
      throw new ValidatorException(new FacesMessage("Login falsch!"));
  }

  public void checkLogin() {
    if(!currentUser.isGuest() && !currentUser.isAdmin()) {
      failureMessage = "Bitte loggen Sie sich ein.";
      FacesContext fc = FacesContext.getCurrentInstance();
      NavigationHandler nh = fc.getApplication().getNavigationHandler();
      nh.handleNavigation(fc, null, "login.xhtml?faces-redirect=true");
    }

  }

  public String logout() {
    this.currentUser.reset();
    return "login.xhtml?faces-redirect=true";
  }

  public void postValidateUser(ComponentSystemEvent ev) {
    UIInput temp = (UIInput) ev.getComponent();
    this.tmpUser = (String) temp.getValue();
  }

  public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    this.tmpPassword = (String) value;

    validateLogin();
    if (!currentUser.isGuest() && !currentUser.isAdmin())
      throw new ValidatorException(new FacesMessage("Login falsch!"));
  }

  public String login() {
    if (currentUser.isAdmin()) {
      this.failureMessage = "";
      return "index.xhtml";
    } else if (currentUser.isGuest()) {
      this.failureMessage = "";
      return "index.xhtml";
    } else {
      this.failureMessage = "Passwort und Benutzername nicht erkannt.";
      return "";
    }
  }
}
