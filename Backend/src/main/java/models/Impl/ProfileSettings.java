package models.Impl;

public class ProfileSettings {
	public final int userId;
	public final String userName;
	public final String userAddress;
	public final String userState;
	public final String userCity;
	public final String userZipCode;

	private ProfileSettings(Builder builder) {
		this.userId = builder.userId;
		this.userName = builder.userName;
		this.userAddress = builder.userAddress;
		this.userState = builder.userState;
		this.userCity = builder.userCity;
		this.userZipCode = builder.userZipCode;
	}

	public int getuserId() {
		return userId;
	}

	public String getuserName() {
		return userName;
	}

	public String getuserAddress() {
		return userAddress;
	}

	public String getUserCity() {
		return userCity;
	}

	public String getUserState() {
		return userState;
	}

	public String getUserZipCode() {
		return userZipCode;
	}

	public static class Builder {
		private int userId;
		private String userName;
		private String userAddress;
		private String userState;
		public String userCity;
		public String userZipCode;

		private Builder() {

		}

		public static Builder newInstance() {
			return new Builder();
		}

		public Builder setuserId(int userId) {
			this.userId = userId;
			return this;
		}

		public Builder setuserName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder setuserAddress(String userAddress) {
			this.userAddress = userAddress;
			return this;
		}

		public Builder setUserCity(String userCity) {
			this.userCity = userCity;
			return this;
		}

		public Builder setUserState(String userState) {
			this.userState = userState;
			return this;
		}

		public Builder setUserZipCode(String userZipCode) {
			this.userZipCode = userZipCode;
			return this;
		}

		public ProfileSettings Build() {
			return new ProfileSettings(this);
		}
	}

}
