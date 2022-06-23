package case_study_furama.exception;

public class CodeServiceException extends Exception {
    public CodeServiceException() {
        super("Invaild format Code Service");
    }

    public CodeServiceException(String message) {
        super(message);
    }
}
