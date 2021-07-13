package services;

import java.sql.SQLException;
import java.util.Map;

import models.Impl.Updates;

public class UpdatesServices {
	public static Updates mapRow(Map<String, Object> posts) throws SQLException {
		Updates updates = Updates.Builder.newInstance().setHansonPostId((int) posts.get("hanson_post_id"))
				.setHansonPostContent(posts.get("hanson_post_content").toString())
				.setHansonPostlikes((int) posts.get("hanson_post_likes"))
				.setHansonPostDate(posts.get("hanson_post_createdDate").toString())
				.setHansonId((int) posts.get("hanson_id"))
				.setHansonUserName(posts.get("hanson_userDetails_name").toString())
				.setHansonUserEmail(posts.get("hanson_userDetails_email").toString()).Build();
		return updates;
	}
}
