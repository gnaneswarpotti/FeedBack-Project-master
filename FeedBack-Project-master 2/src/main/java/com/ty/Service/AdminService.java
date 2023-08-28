package com.ty.Service;

import java.util.List;

import javax.persistence.Query;

import com.ty.dao.AdminDao;
import com.ty.dto.Admin;

public class AdminService {
	AdminDao adminDao = new AdminDao();
	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}
	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);
	}
	public Admin updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}

	public Admin deleteAdmin(int id) {
		return adminDao.deleteAdmin(id);
	}
	public List<Admin> validateAdmin(String email,String password){
		return adminDao.validateAdmin(email, password);
	}
}
