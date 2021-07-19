package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Impl.Courses;

public class CourseServices {
	private List<Courses> courseList = new ArrayList<Courses>();

	public static Courses mapRow(Map<String, Object> posts) throws SQLException {
		Courses course = Courses.Builder.newInstance().setCourseId((int) posts.get("course_id"))
				.setCourseName(posts.get("course_name").toString()).setCourseCredits((int) posts.get("course_credits"))
				.setCourseTutorId((int) posts.get("tutor_id")).setCourseTutorName(posts.get("tutor_name").toString())
				.setCourseTutorMailId(posts.get("tutor_mail").toString()).Build();
		return course;
	}

	public List<Courses> fetchData(List<Map<String, Object>> updates) {
		for (Map<String, Object> posts : updates) {
			try {
				courseList.add(CourseServices.mapRow(posts));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return courseList;
	}
}
