package com.example.likeherotozero;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class CurrentUser implements Serializable {
  boolean admin;

  void reset() {
    this.admin = false;
  }

  boolean isAdmin() {
    return this.admin;
  }
}
