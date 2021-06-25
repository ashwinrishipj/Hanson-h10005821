package services;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserRole {
	public static String fetchUserDetails(int id) {
		JdbcTemplate jdbcTemplate;

		jdbcTemplate = DataSource.intializeDataSource();
		String sql = "select * from hanson_postDetails as h1 join hanson_userDetails as h2 where h1.hanson_id = h2.hanson_id and h1.hanson_id = ?";
		List<Map<String, Object>> postDetails = jdbcTemplate.queryForList(sql, new Object[] { id });

		for (Map<String, Object> posts : postDetails) {
			System.out.println(posts);
		}
		return postDetails.toString();
	}
}
