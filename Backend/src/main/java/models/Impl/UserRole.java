package models.Impl;

import java.util.List;

public class UserRole {
	private final List<Updates> updates;
	private final Notifications notifications;
	private final List<Courses> courses;
	private int userId;
	
	private UserRole(Builder builder) {
		this.notifications = builder.notifications;
		this.updates = builder.updates;
		this.courses = builder.courses;
		this.userId = builder.userId;
	}

	public List<Updates> getUpdates() {
		return updates;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public Notifications getNotifications() {
		return notifications;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public static class Builder {
		private List<Updates> updates;
		private List<Courses> courses;
		private Notifications notifications;
		private int userId;

		private Builder() {

		}

		public static Builder newInstance() {
			return new Builder();
		}

		public Builder setUpdates(List<Updates> updates) {
			this.updates = updates;
			return this;
		}

		public Builder setCourses(List<Courses> courses) {
			this.courses = courses;
			return this;
		}
		
		public Builder setUserId(int userId) {
			this.userId = userId;
			return this;
		}

		public Builder setNotifications(Notifications notifications) {
			this.notifications = notifications;
			return this;
		}

		public UserRole Build() {
			return new UserRole(this);
		}
	}
}
