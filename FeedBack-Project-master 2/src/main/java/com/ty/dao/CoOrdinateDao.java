package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Admin;
import com.ty.dto.CoOrdinate;

public class CoOrdinateDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public CoOrdinate saveCoOrdinate(CoOrdinate coOrdinate) {
		entityTransaction.begin();
		entityManager.persist(coOrdinate);
		entityTransaction.commit();
		return coOrdinate;
	}
	
	public CoOrdinate getCoOrdinateById(int id) {
		return entityManager.find(CoOrdinate.class, id);
	}

	public List<CoOrdinate> getAllCoOrdinate() {
		Query query = entityManager.createQuery("select c from CoOrdinate c");
		return query.getResultList();
	}

	public CoOrdinate updateCoOrdinate(CoOrdinate coOrdinate) {
		CoOrdinate coOrdinate1 = entityManager.find(CoOrdinate.class, coOrdinate.getId());
		coOrdinate1.setId(coOrdinate.getId());
		coOrdinate1.setName(coOrdinate.getName());
		coOrdinate1.setEmail(coOrdinate.getEmail());
		coOrdinate1.setPhone(coOrdinate.getPhone());
		coOrdinate1.setPassword(coOrdinate.getPassword());

		entityTransaction.begin();
		entityManager.merge(coOrdinate1);
		entityTransaction.commit();
		return coOrdinate1;
	}

	public CoOrdinate deleteCoOrdinate(int id) {
		CoOrdinate coOrdinate = entityManager.find(CoOrdinate.class, id);

		entityTransaction.begin();
		entityManager.remove(coOrdinate);
		entityTransaction.commit();
		return coOrdinate;
	}
	public List<CoOrdinate> validateCoOrdinate(String email ,String password) {
		Query query = entityManager.createQuery("select c from CoOrdinate c where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		return query.getResultList();
	}
}
