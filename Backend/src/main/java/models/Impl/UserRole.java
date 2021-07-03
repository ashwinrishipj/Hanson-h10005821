package models.Impl;

public class UserRole {

	private final int hansonPostId;
	private final String hansonPostContent;
	private final int hansonPostlikes;
	private final String hansonPostDate;
	private final int hansonId;
	private final String hansonUserName;
	private final String hansonUserEmail;

	public UserRole(Builder builder) {
		this.hansonPostId = builder.hansonPostId;
		this.hansonPostContent = builder.hansonPostContent;
		this.hansonPostlikes = builder.hansonPostlikes;
		this.hansonPostDate = builder.hansonPostDate;
		this.hansonId = builder.hansonId;
		this.hansonUserName = builder.hansonUserName;
		this.hansonUserEmail = builder.hansonUserEmail;
	}

	public int getHansonPostId() {
		return hansonPostId;
	}

	public String getHansonPostContent() {
		return hansonPostContent;
	}

	public int getHansonPostlikes() {
		return hansonPostlikes;
	}

	public String getHansonPostDate() {
		return hansonPostDate;
	}

	public int getHansonId() {
		return hansonId;
	}

	public String getHansonUserName() {
		return hansonUserName;
	}

	public String getHansonUserEmail() {
		return hansonUserEmail;
	}

	public static class Builder {
		private int hansonPostId;
		private String hansonPostContent;
		private int hansonPostlikes;
		private String hansonPostDate;
		private int hansonId;
		private String hansonUserName;
		private String hansonUserEmail;

		private Builder() {

		}

		public static Builder newInstance() {
			return new Builder();
		}

		public Builder setHansonPostId(int hansonPostId) {
			this.hansonPostId = hansonPostId;
			return this;
		}

		public Builder setHansonPostContent(String hansonPostContent) {
			this.hansonPostContent = hansonPostContent;
			return this;
		}

		public Builder setHansonPostlikes(int hansonPostlikes) {
			this.hansonPostlikes = hansonPostlikes;
			return this;
		}

		public Builder setHansonPostDate(String hansonPostDate) {
			this.hansonPostDate = hansonPostDate;
			return this;
		}

		public Builder setHansonId(int hansonId) {
			this.hansonId = hansonId;
			return this;
		}

		public Builder setHansonUserName(String hansonUserName) {
			this.hansonUserName = hansonUserName;
			return this;
		}

		public Builder setHansonUserEmail(String hansonUserEmail) {
			this.hansonUserEmail = hansonUserEmail;
			return this;
		}

		public UserRole Build() {
			return new UserRole(this);
		}
	}

}
