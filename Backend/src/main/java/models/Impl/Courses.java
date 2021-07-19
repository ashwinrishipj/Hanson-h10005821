package models.Impl;

public class Courses {
	public final int courseId;
	public final String courseName;
	public final int courseCredits;
	public final int courseTutorId;
	public final String courseTutorName;
	public final String courseTutorEmail;

	private Courses(Builder builder) {
		this.courseId = builder.courseId;
		this.courseName = builder.courseName;
		this.courseCredits = builder.courseCredits;
		this.courseTutorId = builder.courseTutorId;
		this.courseTutorName = builder.courseTutorName;
		this.courseTutorEmail = builder.courseTutorEmail;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCourseCredits() {
		return courseCredits;
	}

	public int getCourseTutorId() {
		return courseTutorId;
	}

	public String getCourseTutorName() {
		return courseTutorName;
	}

	public static class Builder {
		private int courseId;
		private String courseName;
		private int courseCredits;
		private int courseTutorId;
		private String courseTutorName;
		private String courseTutorEmail;

		private Builder() {

		}

		public static Builder newInstance() {
			return new Builder();
		}

		public Builder setCourseId(int courseId) {
			this.courseId = courseId;
			return this;
		}

		public Builder setCourseName(String courseName) {
			this.courseName = courseName;
			return this;
		}

		public Builder setCourseCredits(int courseCredits) {
			this.courseCredits = courseCredits;
			return this;
		}

		public Builder setCourseTutorId(int courseTutorId) {
			this.courseTutorId = courseTutorId;
			return this;
		}

		public Builder setCourseTutorName(String courseTutorName) {
			this.courseTutorName = courseTutorName;
			return this;
		}

		public Builder setCourseTutorMailId(String courseTutorEmailId) {
			this.courseTutorEmail = courseTutorEmailId;
			return this;
		}

		public Courses Build() {
			return new Courses(this);
		}
	}
}
