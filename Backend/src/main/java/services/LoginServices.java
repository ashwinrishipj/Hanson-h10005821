package services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import models.Login;

public class LoginServices {

	static UserRoleServices userRoleServices;

	/**
	 * Credentials being validated and returns response with status code 200.
	 * 
	 * @param loginValues
	 * @return 1 for incorrect password, 0 for username not found
	 */
	public static ResponseEntity validateCredentials(Login loginValues) {
		JdbcTemplate jdbcTemplate;

		jdbcTemplate = DataSource.intializeDataSource();

		@SuppressWarnings("deprecation")
		int value = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hanson_users where hanson_username=?",
				new Object[] { loginValues.getEmailId() }, Integer.class);

		if (value == 1) {
			@SuppressWarnings("deprecation")
			int userID = jdbcTemplate.queryForObject("SELECT hanson_id FROM hanson_users where hanson_password=?",
					new Object[] { loginValues.getPassword() }, Integer.class);
			
			System.out.println("userId:" + userID);
			return userID >= 0 ? UserRoleServices.fetchUserDetails(userID)
					: ResponseEntity.status(HttpStatus.OK).body("1");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("0");
		}
	}
}