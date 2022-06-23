package case_study_furama.exception;

public class NameServiceException extends Exception {

    public NameServiceException(){
        super("Invaild format Name Service");
    }
    public NameServiceException(String message) {
        super(message);
    }
}
