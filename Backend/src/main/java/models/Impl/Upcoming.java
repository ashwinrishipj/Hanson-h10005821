package models.Impl;

import java.sql.Date;

public class Upcoming {

	private final int notificationId;
	private final String notificationType;
	private final String notificationContent;
	private final String notificationSubject;
	private final Date notificationDate;
	private final int tutorId;
	private final String tutorName;

	private Upcoming(Builder builder) {
		this.notificationId = builder.notificationId;
		this.notificationType = builder.notificationType;
		this.notificationContent = builder.notificationContent;
		this.notificationSubject = builder.notificationSubject;
		this.notificationDate = builder.notificationDate;
		this.tutorId = builder.tutorId;
		this.tutorName = builder.tutorName;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public String getNotificationContent() {
		return notificationContent;
	}

	public String getNotificationSubject() {
		return notificationSubject;
	}

	public Date getNotificationDate() {
		return notificationDate;
	}

	public int getTutorId() {
		return tutorId;
	}

	public String getTutorName() {
		return tutorName;
	}

	public static class Builder {
		private int notificationId;
		private String notificationType;
		private String notificationContent;
		private String notificationSubject;
		private Date notificationDate;
		private int tutorId;
		private String tutorName;

		private Builder() {

		}

		public static Builder newInstance() {
			return new Builder();
		}

		public Builder setNotificationId(int notificationId) {
			this.notificationId = notificationId;
			return this;
		}

		public Builder setNotificationType(String notificationType) {
			this.notificationType = notificationType;
			return this;
		}

		public Builder setNotificationContent(String notificationContent) {
			this.notificationContent = notificationContent;
			return this;
		}

		public Builder setNotificationSubject(String notificationSubject) {
			this.notificationSubject = notificationSubject;
			return this;
		}

		public Builder setNotificationDate(Date date) {
			this.notificationDate = date;
			return this;
		}

		public Builder setTutorId(int tutorId) {
			this.tutorId = tutorId;
			return this;
		}

		public Builder setTutorName(String tutorName) {
			this.tutorName = tutorName;
			return this;
		}

		public Upcoming Build() {
			return new Upcoming(this);
		}
	}
}
