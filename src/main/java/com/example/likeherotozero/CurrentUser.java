package com.example.likeherotozero;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class CurrentUser implements Serializable {
  private boolean admin;

  private boolean guest;

  public void reset() {
    this.admin = false;
    this.guest = false;
  }

  public boolean isAdmin() {
    return this.admin;
  }

  public boolean isGuest() {
    return this.guest;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public void setGuest(boolean guest) {
    this.guest = guest;
  }
}
