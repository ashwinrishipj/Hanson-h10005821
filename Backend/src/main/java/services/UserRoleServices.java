package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import models.Impl.UserRole;

public class UserRoleServices {
	private static UserRole userRole;
	private static List<UserRole> userRoleList = new ArrayList<UserRole>();

	public static UserRole mapRow(Map<String, Object> posts) throws SQLException {
		return userRole = UserRole.Builder.newInstance().setHansonPostId((int) posts.get("hanson_post_id"))
				.setHansonPostContent(posts.get("hanson_post_content").toString())
				.setHansonPostlikes((int) posts.get("hanson_post_likes"))
				.setHansonPostDate(posts.get("hanson_post_createdDate").toString())
				.setHansonId((int) posts.get("hanson_id"))
				.setHansonUserName(posts.get("hanson_userDetails_name").toString())
				.setHansonUserEmail(posts.get("hanson_userDetails_email").toString()).Build();
	}

	public static ResponseEntity fetchUserDetails(int id) {
		JdbcTemplate jdbcTemplate;

		jdbcTemplate = DataSource.intializeDataSource();
		String sql = "select * from hanson_postDetails as h1 join hanson_userDetails as h2 where h1.hanson_id = h2.hanson_id and h1.hanson_id = ?";
		List<Map<String, Object>> postDetails = jdbcTemplate.queryForList(sql, new Object[] { id });

		for (Map<String, Object> posts : postDetails) {
			try {
				userRole = UserRoleServices.mapRow(posts);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			userRoleList.add(userRole);
		}

		return ResponseEntity
	            .status(HttpStatus.CREATED)                 
	            .body(userRoleList);
	}
}
