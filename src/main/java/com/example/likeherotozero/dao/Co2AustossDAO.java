package com.example.likeherotozero.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;

@Named
@ApplicationScoped
public class Co2AustossDAO {

  EntityManager entityManager;

  CriteriaBuilder criteriaBuilder;

  public Co2AustossDAO() {
    entityManager = Persistence.createEntityManagerFactory("co2austoss").createEntityManager();
    criteriaBuilder = entityManager.getCriteriaBuilder();
  }

}
