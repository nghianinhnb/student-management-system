package general.exceptions;

public class DuplicateStudentCodeException extends RuntimeException {
    public DuplicateStudentCodeException(String message) {
        super(message);
    }
}
