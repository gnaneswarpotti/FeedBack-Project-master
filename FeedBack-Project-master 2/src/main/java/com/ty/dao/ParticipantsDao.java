package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Participants;

public class ParticipantsDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Participants saveParticipants(Participants participants) {
		entityTransaction.begin();
		entityManager.persist(participants);
		entityTransaction.commit();
		return participants;
	}

	public List<Participants> getAllParticipants() {
		Query query = entityManager.createQuery("select p from Participants p");
		return query.getResultList();
	}

	public Participants updateParticipants(Participants participants) {
		Participants participants1 = entityManager.find(Participants.class, participants.getId());
		participants1.setId(participants.getId());
		participants1.setName(participants.getName());
		participants1.setEmail(participants.getEmail());
		participants1.setPhone(participants.getPhone());

		entityTransaction.begin();
		entityManager.merge(participants1);
		entityTransaction.commit();
		return participants1;
	}

	public Participants deleteParticipants(int id) {
		Participants participants = entityManager.find(Participants.class, id);

		entityTransaction.begin();
		entityManager.remove(participants);
		entityTransaction.commit();
		return participants;
	}

}
