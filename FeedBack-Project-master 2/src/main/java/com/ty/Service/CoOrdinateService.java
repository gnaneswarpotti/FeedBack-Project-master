package com.ty.Service;

import java.util.List;

import javax.persistence.Query;

import com.ty.dao.CoOrdinateDao;
import com.ty.dto.Admin;
import com.ty.dto.CoOrdinate;

public class CoOrdinateService {
	CoOrdinateDao coOrdinateDao = new CoOrdinateDao();

	public CoOrdinate saveCoOrdinate(CoOrdinate coOrdinate) {
		return coOrdinateDao.saveCoOrdinate(coOrdinate);
	}

	public CoOrdinate getCoOrdinateById(int id) {
		return coOrdinateDao.getCoOrdinateById(id);
	}

	public List<CoOrdinate> getAllCoOrdinate() {
		return coOrdinateDao.getAllCoOrdinate();
	}

	public CoOrdinate updateCoOrdinate(CoOrdinate coOrdinate) {
		return coOrdinateDao.updateCoOrdinate(coOrdinate);
	}

	public CoOrdinate deleteCoOrdinate(int id) {
		return coOrdinateDao.deleteCoOrdinate(id);
	}
	public List<CoOrdinate> validateCoOrdinate(String email ,String password) {
		return coOrdinateDao.validateCoOrdinate(email, password);
	}
}
