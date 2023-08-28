package com.ty.Service;

import java.util.List;

import com.ty.dao.CoursesDao;
import com.ty.dto.Courses;

public class CoursesService {
	CoursesDao coursesDao = new CoursesDao();

	public Courses createCourses(Courses courses) {
		return coursesDao.createCourses(courses);
	}

	public List<Courses> getAllCourses() {
		return coursesDao.getAllCourses();
	}

	public Courses getCourseById(int id) {
		return coursesDao.getCourseById(id);
	}

	public Courses updateCourses(Courses courses) {
		return coursesDao.updateCourses(courses);
	}

	public Courses deleteCourses(int id) {
		return coursesDao.deleteCourses(id);
	}
}
