package com.ty.Service;

import java.util.List;

import com.ty.dao.TrainningProgramsDao;
import com.ty.dto.TrainningPrograms;

public class TrainningProgramsService {
	TrainningProgramsDao trainningProgramsDao = new TrainningProgramsDao();
	public TrainningPrograms createTrainningPrograms(TrainningPrograms trainningPrograms) {
		return trainningProgramsDao.createTrainningPrograms(trainningPrograms);
	}

	public List<TrainningPrograms> getAllTrainningPrograms() {
		return trainningProgramsDao.getAllTrainningPrograms();
	}

	public TrainningPrograms getTrainningProgramsById(int id) {
		return trainningProgramsDao.getTrainningProgramsById(id);
	}

	public TrainningPrograms updateTrainningPrograms(TrainningPrograms trainningPrograms) {
		return trainningProgramsDao.updateTrainningPrograms(trainningPrograms);
	}

	public TrainningPrograms deleteTrainningPrograms(int id) {
		return trainningProgramsDao.deleteTrainningPrograms(id);
	}
}
