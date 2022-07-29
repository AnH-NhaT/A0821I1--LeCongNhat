package example.validation;

public class CustomerDuplicateException extends Exception {
	private static final long serialVersionUID = 1L;

	public CustomerDuplicateException(String message) {
		super(message);
	}
}
