package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Courses;

public class CoursesDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Courses createCourses(Courses courses) {
		entityTransaction.begin();
		entityManager.persist(courses);
		entityTransaction.commit();
		return courses;
	}

	public List<Courses> getAllCourses() {
		Query query = entityManager.createQuery("select c from Courses c");
		return query.getResultList();
	}

	public Courses getCourseById(int id) {
		return entityManager.find(Courses.class, id);
	}

	public Courses updateCourses(Courses courses) {
		Courses courses2 = entityManager.find(Courses.class, courses.getId());
		courses2.setId(courses.getId());
		courses2.setCourseName(courses.getCourseName());
		courses2.setFees(courses.getFees());
		courses2.setDuration(courses.getDuration());
		
		
		entityTransaction.begin();
		entityManager.merge(courses2);
		entityTransaction.commit();
		return courses2;
	}

	public Courses deleteCourses(int id) {
		Courses courses = entityManager.find(Courses.class, id);
		entityTransaction.begin();
		entityManager.remove(courses);
		entityTransaction.commit();
		return courses;
	}
}
