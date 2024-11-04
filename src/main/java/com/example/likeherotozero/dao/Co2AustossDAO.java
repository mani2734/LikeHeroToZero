package com.example.likeherotozero.dao;

import com.example.likeherotozero.entity.Co2Austoss;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class Co2AustossDAO implements Serializable {

  EntityManager entityManager;

  CriteriaBuilder criteriaBuilder;

  public Co2AustossDAO() {
    this.entityManager = Persistence.createEntityManagerFactory("co2austoss").createEntityManager();
    this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
  }

  public void merge(Co2Austoss co2) {
    this.entityManager.merge(co2);
  }
  public void persist(Co2Austoss co2) {
    this.entityManager.persist(co2);
  }

  public List<Co2Austoss> getAll() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Co2Austoss> query = cb.createQuery(Co2Austoss.class);
    Root<Co2Austoss> co2AustossRoot = query.from(Co2Austoss.class);

    query.select(co2AustossRoot);

    return entityManager.createQuery(query).getResultList();
  }

  public Co2Austoss getNewestEntryForCountry(String country) {
    CriteriaQuery<Co2Austoss> cq = this.criteriaBuilder.createQuery(Co2Austoss.class);
    Root<Co2Austoss> co2AustossRoot = cq.from(Co2Austoss.class);
    cq.select(co2AustossRoot)
      .where(this.criteriaBuilder
                 .equal(co2AustossRoot.get("country"), country)).orderBy(this.criteriaBuilder.desc(co2AustossRoot.get("year_")));
    List<Co2Austoss> result = this.entityManager.createQuery(cq).getResultList();
    if(result != null && !result.isEmpty()) {
      return result.get(0);
    }
    return null;
  }

}
