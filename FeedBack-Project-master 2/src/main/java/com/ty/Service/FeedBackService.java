package com.ty.Service;

import java.util.List;

import javax.servlet.RequestDispatcher;

import com.ty.dao.FeedBackDao;
import com.ty.dto.Courses;
import com.ty.dto.Faculties;
import com.ty.dto.FeedBack;

public class FeedBackService {
	FeedBackDao feedBackDao = new FeedBackDao();

	public FeedBack createFeedBack(FeedBack feedBack) {
		return feedBackDao.createFeedBack(feedBack);
	}

	public List<FeedBack> getAllFeedBack() {
		return feedBackDao.getAllFeedBack();
	}

	public FeedBack getFeedBackById(int id) {
		return feedBackDao.getFeedBackById(id);
	}

	public FeedBack updateCourses(FeedBack feedBack) {
		CoursesService coursesService = new CoursesService();
		List<Courses> courses = coursesService.getAllCourses();
		for (Courses courses2 : courses) {
			if (courses2.getCourseName().equalsIgnoreCase(feedBack.getCourseName())) {
				feedBack.setCourseName(courses2.getCourseName());
			} else {
				feedBack.setCourseName("null");
			}
		}
		FacultiesService facultiesService = new FacultiesService();
		List<Faculties> faculties = facultiesService.getAllFaculties();
		for (Faculties faculties2 : faculties) {
			if (faculties2.getName().equalsIgnoreCase(feedBack.getFacultyName())) {
				feedBack.setFacultyName(faculties2.getName());
			} else {
				feedBack.setFacultyName("null");
			}
		}
		return feedBackDao.updateCourses(feedBack);
	}

	public FeedBack deleteCoursesById(int id) {
		return feedBackDao.deleteFeedBackById(id);
	}
}
