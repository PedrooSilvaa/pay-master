package tech.silva.payment.exception;

public class UserUniqueViolationException extends RuntimeException {

    public UserUniqueViolationException(String message) {
        super(message);
    }
}
