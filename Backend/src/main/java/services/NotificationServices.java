package services;

import java.sql.SQLException;
import java.util.Map;

import models.Impl.Notifications;
import models.Impl.OverDue;

public class NotificationServices {
	public static Notifications mapRow(Map<String, Object> posts) throws SQLException {
		OverDue overDue = OverDue.Builder.newInstance().setNotificationId((int) posts.get("notification_id"))
				.setNotificationContent(posts.get("notification_content").toString())
				.setNotificationDate(posts.get("notification_date").toString())
				.setNotificationSubject(posts.get("notification_subject").toString())
				.setTutorId((int) posts.get("tutor_id")).setTutorName(posts.get("tutor_name").toString()).Build();
		return null;
	}
}
