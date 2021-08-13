package services;

import org.springframework.jdbc.core.JdbcTemplate;

import models.Impl.ProfileSettings;

public class InsertProfileServices {

	public static boolean insertProfile(ProfileSettings profileSettings) {
		JdbcTemplate jdbcTemplate;
		int rows = 0;
		jdbcTemplate = DataSource.intializeDataSource();

		String updateQuery = "UPDATE hanson_userDetails SET hanson_userDetails_name = ?,address=?, City= ?, state = ?,zip= ? WHERE hanson_userDetails_id = ? ";
		try {
			rows = jdbcTemplate.update(updateQuery, profileSettings.getuserName(), profileSettings.getuserAddress(),
					profileSettings.getUserCity(), profileSettings.getUserState(), profileSettings.getUserZipCode(),
					profileSettings.getuserId());
		} catch (Exception e) {
			System.out.println("exception occurred:" + e);
			return false;
		}
		System.out.println(rows + " rows updated");
		return true;
	}
}
