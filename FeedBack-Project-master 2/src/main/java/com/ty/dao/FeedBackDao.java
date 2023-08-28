package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.FeedBack;

public class FeedBackDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public FeedBack createFeedBack(FeedBack feedBack) {
		entityTransaction.begin();
		entityManager.persist(feedBack);
		entityTransaction.commit();
		return feedBack;
	}

	public List<FeedBack> getAllFeedBack() {
		Query query = entityManager.createQuery("select c from FeedBack c");
		return query.getResultList();
	}

	public FeedBack getFeedBackById(int id) {
		return entityManager.find(FeedBack.class, id);
	}

	public FeedBack updateCourses(FeedBack feedBack) {
		FeedBack feedBack2 = entityManager.find(FeedBack.class, feedBack.getId());
		feedBack2.setId(feedBack.getId());
		feedBack2.setParticepateName(feedBack.getParticepateName());
		feedBack2.setRatings(feedBack.getRatings());
		feedBack2.setDescription(feedBack.getDescription());

		entityTransaction.begin();
		entityManager.merge(feedBack2);
		entityTransaction.commit();
		return feedBack2;
	}

	public FeedBack deleteFeedBackById(int id) {
		FeedBack feedBack = entityManager.find(FeedBack.class, id);
		entityTransaction.begin();
		entityManager.remove(feedBack);
		entityTransaction.commit();
		return feedBack;
	}
}
