package services;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import models.Login;

public class LoginServices {

	static UserRole userRole;

	public static String validateCredentials(Login loginValues) {
		JdbcTemplate jdbcTemplate;

		jdbcTemplate = DataSource.intializeDataSource();

		@SuppressWarnings("deprecation")
		int value = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hanson_users where hanson_username=?",
				new Object[] { loginValues.getEmailId() }, Integer.class);

		if (value == 1) {
			int passwordValue = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hanson_users where hanson_password=?",
					new Object[] { loginValues.getPassword() }, Integer.class);

			return passwordValue == 1 ? UserRole.fetchUserDetails(passwordValue) : "incorrect password";
		} else {
			return "user not found. Please register";
		}
	}
}