package demo.csod.securitydemo.csod.spring_security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> handleUserNotFound(ResourceNotFound resourceNotFound) {
        return new ResponseEntity<>("User is not found with following Id", HttpStatus.NOT_FOUND);
    }

}
