package models;

/**
 * <p>
 * An Interface for the Login build to retrieve the user credentials.
 * </p>
 * <p>
 * copyright & copy; Ashwin Rishi.
 * </p>
 * 
 * @author H10005821
 */
public interface Login {
	/**
	 * @return an EmailId of String. This value will never be {@code null} or empty.
	 */
	String getEmailId();

	/**
	 * @return an password of String. This value will never be {@code null} or
	 *         empty.
	 */
	String getPassword();
}
