package util;

public class TracksNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TracksNotFoundException(String error) {
		super(error);
	}
}
