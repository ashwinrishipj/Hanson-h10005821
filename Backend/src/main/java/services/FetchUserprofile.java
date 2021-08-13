package services;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class FetchUserprofile {
	public static ResponseEntity fetchUserDetails(int id) {
		JdbcTemplate jdbcTemplate;
		String postsSql = null;
		List<Map<String, Object>> profileResult = null;

		jdbcTemplate = DataSource.intializeDataSource();
		postsSql = "select * from hanson_userDetails where hanson_id = ?";
		try {
			profileResult = jdbcTemplate.queryForList(postsSql, new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(profileResult);
	}
}
