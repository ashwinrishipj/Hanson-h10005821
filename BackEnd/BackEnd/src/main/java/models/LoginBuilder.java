package models;

/**
 * <p>
 * LoginBuilder.
 * </p>
 * <p>
 * copyright & copy: Ashwin Rishi
 * </p>
 * 
 * @author H10005821.
 */
public interface LoginBuilder {
	/**
	 * Initializes the EmailId from the parameter.
	 * 
	 * @param emailId and this cannot be {@code null} or empty.
	 * @return the object LoginBuilder for emailId defined.
	 */
	LoginBuilder emailId(String emailId);

	/**
	 * Initializes the Password from the parameter.
	 * 
	 * @param password and this cannot be {@code null} or empty
	 * @returns the LoginBuilder object for the password defined.
	 */
	LoginBuilder password(String password);

	/**
	 * Constructs a new {@link Login} instance from the values set on this builder.
	 * 
	 * @throws IllegalStateException
	 *                               <ul>
	 *                               <li>if {@link #emailId(String)} was not
	 *                               called.</li>
	 *                               <li>if {@link #password(String)} was not
	 *                               called.</li>
	 *                               </ul>
	 * @return an instance of the Login object.
	 */
	Login build();
}
