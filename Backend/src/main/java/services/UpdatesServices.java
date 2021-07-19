package services;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Impl.Updates;

public class UpdatesServices {
	List<Updates> updatesList = new ArrayList<Updates>();

	public static Updates mapRow(Map<String, Object> posts) throws SQLException {
		Updates updates = Updates.Builder.newInstance().setHansonPostId((int) posts.get("hanson_post_id"))
				.setHansonPostContent(posts.get("hanson_post_content").toString())
				.setHansonPostlikes((int) posts.get("hanson_post_likes"))
				.setHansonPostDate((Date) posts.get("hanson_post_createdDate"))
				.setHansonId((int) posts.get("hanson_id"))
				.setHansonUserName(posts.get("hanson_userDetails_name").toString())
				.setHansonUserEmail(posts.get("hanson_userDetails_email").toString()).Build();
		return updates;
	}

	public List<Updates> fetchData(List<Map<String, Object>> updates) {
		for (Map<String, Object> posts : updates) {
			try {
				updatesList.add(UpdatesServices.mapRow(posts));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return updatesList;
	}
}
