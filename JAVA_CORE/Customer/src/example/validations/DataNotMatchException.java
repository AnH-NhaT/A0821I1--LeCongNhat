package example.validations;

public class DataNotMatchException extends Exception {
	private static final long serialVersionUID = 1L;

	public DataNotMatchException(String message) {
		super(message);
	}
}
