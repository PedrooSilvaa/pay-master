package tech.silva.payment.web.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.silva.payment.exception.UserUniqueViolationException;

@RestControllerAdvice
public class ApiHandlerException {

    //User
    @ExceptionHandler(UserUniqueViolationException.class)
    public ResponseEntity<ErrorMessage> userUniqueViolationException(RuntimeException ex, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));
    }

}
