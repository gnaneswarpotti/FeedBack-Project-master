package com.ty.Service;

import java.util.List;

import javax.persistence.Query;

import com.ty.dao.ParticipantsDao;
import com.ty.dto.Participants;

public class ParticipantsService {
	ParticipantsDao participantsDao = new ParticipantsDao();
	public Participants saveParticipants(Participants participants) {
		return participantsDao.saveParticipants(participants);
	}

	public List<Participants> getAllParticipants() {
		return participantsDao.getAllParticipants();
	}

	public Participants updateParticipants(Participants participants) {
		return participantsDao.updateParticipants(participants);
	}

	public Participants deleteParticipants(int id) {
		return participantsDao.deleteParticipants(id);
	}
}
