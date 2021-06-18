package models.Impl;

import exceptions.ArgumentChecker;
import exceptions.Validator;
import models.Login;
import models.LoginBuilder;

/**
 * <p>
 * Implementation class of {@link Login}
 * </p>
 * <p>
 * copyright & copy : Ashwin Rishi
 * </p>
 * 
 * @author H10005821
 */
public class LoginImpl implements Login {
	private final String emailId;
	private final String password;

	private LoginImpl(Builder builder) {
		this.emailId = builder.emailId;
		this.password = builder.password;
	}

	@Override
	public String getEmailId() {
		return emailId;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginImpl other = (LoginImpl) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	/**
	 * <p>
	 * Builder class Implementation of {@link LoginBuilder}
	 * </p>
	 * <p>
	 * copyright & copy : Ashwin Rishi
	 * </p>
	 * 
	 * @author H10005821
	 */
	public static class Builder implements LoginBuilder {

		private String emailId;
		private String password;

		@Override
		public LoginBuilder emailId(String emailId) {
			this.emailId = ArgumentChecker.rejectIfNullOrEmpty(emailId);
			return this;
		}

		@Override
		public LoginBuilder password(String password) {
			this.password = ArgumentChecker.rejectIfNullOrEmpty(password);
			return this;
		}

		@Override
		public Login build() {
			Validator.validateNotNullOrEmpty(emailId);
			Validator.validateNotNullOrEmpty(password);
			return new LoginImpl(this);
		}
	}
}
