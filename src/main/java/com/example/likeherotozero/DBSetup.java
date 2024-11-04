package com.example.likeherotozero;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Named
@ViewScoped
public class DBSetup implements Serializable {

  private static final String csvFilePath = "C:\\Local\\developer-workspace\\LIkeHeroToZero\\src\\main\\resources\\annual-co2-emissions-per-country.csv";


  public void importData() {
    try {
      Class.forName("org.h2.Driver");
      Connection conn = DriverManager.getConnection("jdbc:h2:mem:myDB;DB_CLOSE_DELAY=-1", "db", "db");
      Statement st = conn.createStatement();
      String createTable = "CREATE TABLE emissions (country VARCHAR(100),code VARCHAR(20), year_ VARCHAR(4), co2_emissions DOUBLE);";
      st.execute(createTable);

      Statement stmt = conn.createStatement();
      String sql = "INSERT INTO emissions SELECT * FROM CSVREAD('" + csvFilePath + "')";
      stmt.execute(sql);
      System.out.println("Data imported successfully.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
