package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import models.Impl.Courses;
import models.Impl.Notifications;
import models.Impl.Updates;
import models.Impl.UserRole;

public class UserRoleServices {
	public static ResponseEntity fetchUserDetails(int id) {
		UpdatesServices updatesServices = new UpdatesServices();
		CourseServices courseServices = new CourseServices();
		NotificationServices notificationServices = new NotificationServices();

		Executor executor = Executors.newFixedThreadPool(3);
		JdbcTemplate jdbcTemplate;

		List<Updates> updates = null;
		Notifications notifications = null;
		List<Courses> courses = null;

		jdbcTemplate = DataSource.intializeDataSource();
		String postsSql = "select * from hanson_postDetails as h1 join hanson_userDetails as h2 where h1.hanson_id = h2.hanson_id and h1.hanson_id = ?";
		List<Map<String, Object>> updateDetails = jdbcTemplate.queryForList(postsSql, new Object[] { id });

		String notificationsSql = "select * from hanson_tutors,notifications as h1 join hanson_userDetails as h2 where h1.hanson_userDetails_id = h2.hanson_userDetails_id and h1.hanson_userDetails_id = ?";
		List<Map<String, Object>> notificationResults = jdbcTemplate.queryForList(notificationsSql,
				new Object[] { id });

		String coursesSql = "select * from hanson_tutors,hanson_courses as h1 join hanson_userDetails h2 where h1.hanson_userDetails_id = h2.hanson_userDetails_id and h1.hanson_userDetails_id = ?";
		List<Map<String, Object>> coursesResult = jdbcTemplate.queryForList(coursesSql, new Object[] { id });

		try {
			updates = updatesServices.fetchData(updateDetails);
			courses = courseServices.fetchData(coursesResult);
			notifications = notificationServices.fetchData(notificationResults);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserRole userRole = UserRole.Builder.newInstance().setCourses(courses).setNotifications(notifications)
				.setUpdates(updates).setUserId(id).Build();

		return ResponseEntity.status(HttpStatus.CREATED).body(userRole);
	}
}
