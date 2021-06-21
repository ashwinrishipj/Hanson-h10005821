package services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import models.Login;

public class LoginServices {

	public static boolean validateCredentials(Login loginValues) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		dataSource.setUrl("jdbc:mysql://localhost:3306/hanson_application");
		dataSource.setUsername("root");
		dataSource.setPassword("hanson");

		JdbcTemplate jtm = new JdbcTemplate(dataSource);
		int result = jtm.queryForObject("SELECT * FROM hanson_users", Integer.class);
		System.out.println("result:" + result);
		return false;
	}

}