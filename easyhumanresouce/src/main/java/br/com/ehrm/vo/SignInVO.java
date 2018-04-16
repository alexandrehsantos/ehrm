package br.com.ehrm.vo;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class SignInVO.
 */
public class SignInVO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7045619961433516580L;

	/** The site name. */
	private String siteName;

	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

	/**
	 * Gets the site name.
	 *
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * Sets the site name.
	 *
	 * @param siteName
	 *            the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SignInVO [siteName=" + siteName + ", userName=" + userName + ", password=" + password + "]";
	}

}
