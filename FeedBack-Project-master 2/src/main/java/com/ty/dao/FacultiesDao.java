package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Faculties;

public class FacultiesDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Faculties saveFaculties(Faculties faculties) {
		entityTransaction.begin();
		entityManager.persist(faculties);
		entityTransaction.commit();
		return faculties;
	}

	public Faculties getFacultiesById(int id) {
		return entityManager.find(Faculties.class, id);
	}

	public List<Faculties> getAllFaculties() {
		Query query = entityManager.createQuery("select f from Faculties f");
		return query.getResultList();
	}

	public Faculties updateFaculties(Faculties faculties) {
		Faculties faculties1 = entityManager.find(Faculties.class, faculties.getId());
		faculties1.setId(faculties.getId());
		faculties1.setName(faculties.getName());
		faculties1.setEmail(faculties.getEmail());
		faculties1.setPhone(faculties.getPhone());
		faculties1.setPassword(faculties.getPassword());
		faculties1.setSalary(faculties.getSalary());
		faculties1.setSkills(faculties.getSkills());

		entityTransaction.begin();
		entityManager.merge(faculties1);
		entityTransaction.commit();
		return faculties1;
	}

	public Faculties deleteFaculties(int id) {
		Faculties faculties = entityManager.find(Faculties.class, id);

		entityTransaction.begin();
		entityManager.remove(faculties);
		entityTransaction.commit();
		return faculties;
	}
}
