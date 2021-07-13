package models.Impl;

public class OverDue {
	private final int notificationId;
	private final String notificationContent;
	private final String notificationSubject;
	private final String notificationDate;
	private final int tutorId;
	private final String tutorName;

	public OverDue(Builder builder) {
		this.notificationId = builder.notificationId;
		this.notificationContent = builder.notificationContent;
		this.notificationSubject = builder.notificationSubject;
		this.notificationDate = builder.notificationDate;
		this.tutorId = builder.tutorId;
		this.tutorName = builder.tutorName;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public String getNotificationContent() {
		return notificationContent;
	}

	public String getNotificationSubject() {
		return notificationSubject;
	}

	public String getNotificationDate() {
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
		private String notificationContent;
		private String notificationSubject;
		private String notificationDate;
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

		public Builder setNotificationContent(String notificationContent) {
			this.notificationContent = notificationContent;
			return this;
		}

		public Builder setNotificationSubject(String notificationSubject) {
			this.notificationSubject = notificationSubject;
			return this;
		}

		public Builder setNotificationDate(String notificationDate) {
			this.notificationDate = notificationDate;
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

		public OverDue Build() {
			return new OverDue(this);
		}
	}
}
