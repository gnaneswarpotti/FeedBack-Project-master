package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Courses;
import com.ty.dto.TrainningPrograms;

public class TrainningProgramsDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public TrainningPrograms createTrainningPrograms(TrainningPrograms trainningPrograms) {
		entityTransaction.begin();
		entityManager.persist(trainningPrograms);
		entityTransaction.commit();
		return trainningPrograms;
	}

	public List<TrainningPrograms> getAllTrainningPrograms() {
		Query query = entityManager.createQuery("select t from TrainningPrograms t");
		return query.getResultList();
	}

	public TrainningPrograms getTrainningProgramsById(int id) {
		return entityManager.find(TrainningPrograms.class, id);
	}

	public TrainningPrograms updateTrainningPrograms(TrainningPrograms trainningPrograms) {
		TrainningPrograms trainningPrograms2 = entityManager.find(TrainningPrograms.class, trainningPrograms.getId());
		trainningPrograms2.setId(trainningPrograms.getId());
		trainningPrograms2.setName(trainningPrograms.getName());
		trainningPrograms2.setStartingDate(trainningPrograms.getStartingDate());
		trainningPrograms2.setEndingDate(trainningPrograms.getEndingDate());
		trainningPrograms2.setFacultiesNames(trainningPrograms.getFacultiesNames());

		entityTransaction.begin();
		entityManager.merge(trainningPrograms2);
		entityTransaction.commit();
		return trainningPrograms2;
	}

	public TrainningPrograms deleteTrainningPrograms(int id) {
		TrainningPrograms trainningPrograms = entityManager.find(TrainningPrograms.class, id);
		entityTransaction.begin();
		entityManager.remove(trainningPrograms);
		entityTransaction.commit();
		return trainningPrograms;
	}
}
