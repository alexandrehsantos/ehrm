package br.com.ehrm.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class EhrmException.
 */
public class EhrmException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8524830506672771363L;

	/**
	 * Instantiates a new ehrm exception.
	 */
	public EhrmException() {

	}

	/**
	 * Instantiates a new ehrm exception.
	 *
	 * @param message
	 *            the message
	 */
	public EhrmException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new ehrm exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public EhrmException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new ehrm exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public EhrmException(Throwable cause) {
		super(cause);
	}

}
