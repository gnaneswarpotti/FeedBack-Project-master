package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Admin;

public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Admin saveAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}

	public List<Admin> getAllAdmin() {
		Query query = entityManager.createQuery("select a from Admin a");
		return query.getResultList();
	}
	public Admin getAdminById(int id) {
		return entityManager.find(Admin.class, id);
	}

	public Admin updateAdmin(Admin admin) {
		Admin admin1 = entityManager.find(Admin.class, admin.getId());
		admin1.setId(admin.getId());
		admin1.setName(admin.getName());
		admin1.setEmail(admin.getEmail());
		admin1.setPhone(admin.getPhone());
		admin1.setPassword(admin.getPassword());

		entityTransaction.begin();
		entityManager.merge(admin1);
		entityTransaction.commit();
		return admin1;
	}

	public Admin deleteAdmin(int id) {
		Admin admin = entityManager.find(Admin.class, id);

		entityTransaction.begin();
		entityManager.remove(admin);
		entityTransaction.commit();
		return admin;
	}
	public List<Admin> validateAdmin(String email ,String password) {
		Query query = entityManager.createQuery("select a from Admin a where a.email=?1 and a.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		return query.getResultList();
		
	}
}
