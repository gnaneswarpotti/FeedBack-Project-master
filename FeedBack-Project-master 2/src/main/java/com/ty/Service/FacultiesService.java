package com.ty.Service;

import java.util.List;

import com.ty.dao.FacultiesDao;
import com.ty.dto.Faculties;

public class FacultiesService {
	FacultiesDao facultiesDao = new FacultiesDao();

	public Faculties saveFaculties(Faculties faculties) {
		return facultiesDao.saveFaculties(faculties);
	}

	public Faculties getFacultiesById(int id) {
		return facultiesDao.getFacultiesById(id);
	}

	public List<Faculties> getAllFaculties() {
		return facultiesDao.getAllFaculties();
	}

	public Faculties updateFaculties(Faculties faculties) {
		return facultiesDao.updateFaculties(faculties);
	}

	public Faculties deleteFaculties(int id) {
		return facultiesDao.deleteFaculties(id);
	}
}
