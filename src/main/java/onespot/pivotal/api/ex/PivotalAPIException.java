package onespot.pivotal.api.ex;

public class PivotalAPIException extends RuntimeException {
	/**
	 * The serial id.
	 */
	private static final long serialVersionUID = 4895542956126605694L;

	public PivotalAPIException() {
	        super();
	    }

	public PivotalAPIException(String message) {
	        super(message);
	    }

	public PivotalAPIException(String message, Throwable cause) {
	        super(message, cause);
	    }

	public PivotalAPIException(Throwable cause) {
	        super(cause);
	    }
}
