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

public class UserRoleServices {
	public static ResponseEntity fetchUserDetails(int id) {
		List<Object> userRoleList = new ArrayList<>();
		Executor executor = Executors.newFixedThreadPool(3);
		JdbcTemplate jdbcTemplate;
		Future<Updates> futureUpdates;
		Future<Notifications> futureNotifications;
		Future<Courses> futureCourses;

		Updates updates;
		Notifications notifications;
		Courses courses;

		jdbcTemplate = DataSource.intializeDataSource();
		String sql = "select * from hanson_postDetails as h1 join hanson_userDetails as h2 where h1.hanson_id = h2.hanson_id and h1.hanson_id = ?";
		List<Map<String, Object>> postDetails = jdbcTemplate.queryForList(sql, new Object[] { id });

		for (Map<String, Object> posts : postDetails) {
			try {
				futureUpdates = ((ExecutorService) executor).submit(() -> UpdatesServices.mapRow(posts));
				futureNotifications = ((ExecutorService) executor).submit(() -> NotificationServices.mapRow(posts));
				futureCourses = ((ExecutorService) executor).submit(() -> CourseServices.mapRow(posts));

				updates = futureUpdates.get();
				notifications = futureNotifications.get();
				courses = futureCourses.get();

				userRoleList.add(updates);
				userRoleList.add(notifications);
				userRoleList.add(courses);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(userRoleList);
	}
}
