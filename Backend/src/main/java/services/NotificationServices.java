package services;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import models.Impl.Notifications;
import models.Impl.OverDue;
import models.Impl.Upcoming;

public class NotificationServices {
	private List<Upcoming> upcomingList = new ArrayList<Upcoming>();
	private List<OverDue> overdueList = new ArrayList<OverDue>();
	private Notifications notifications;

	LocalDate todaysLocalDate = LocalDate.now();
	Date todaysDate = java.sql.Date.valueOf(todaysLocalDate);

	public static Upcoming mapUpcomingRow(Map<String, Object> posts) throws SQLException {
		Upcoming upcoming = Upcoming.Builder.newInstance()
				.setNotificationContent(posts.get("notification_content").toString())
				.setNotificationDate((Date) posts.get("notification_date"))
				.setNotificationType(posts.get("notification_type").toString())
				.setNotificationSubject(posts.get("notification_subject").toString())
				.setTutorId((int) posts.get("tutor_id")).setTutorName(posts.get("tutor_name").toString()).Build();
		return upcoming;

	}

	public static OverDue mapOverDueRow(Map<String, Object> posts) throws SQLException {
		OverDue overDue = OverDue.Builder.newInstance().setNotificationId((int) posts.get("notification_id"))
				.setNotificationContent(posts.get("notification_content").toString())
				.setNotificationDate((Date) posts.get("notification_date"))
				.setNotificationSubject(posts.get("notification_subject").toString())
				.setTutorId((int) posts.get("tutor_id")).setTutorName(posts.get("tutor_name").toString()).Build();
		return overDue;
	}

	public Notifications fetchData(List<Map<String, Object>> notification) {
		for (Map<String, Object> posts : notification) {
			try {
				Date NotificationDate = (Date) posts.get("notification_date");

				if (NotificationDate.after(todaysDate) && posts.get("notification_type").toString() != "webinar") {
					upcomingList.add(NotificationServices.mapUpcomingRow(posts));
				} else {
					overdueList.add(NotificationServices.mapOverDueRow(posts));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		notifications = Notifications.Builder.newInstance().setUpcoming(upcomingList).setOverDue(overdueList).Build();
		return notifications;
	}
}
