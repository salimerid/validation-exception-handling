package com.salimerid.validationexceptionhandling.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ApplicationGlobalExceptionHandler {

    // for generic exception handle
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorCode(GlobalErrorCode.ERROR_STUDENT_NOT_FOUND)
                .errorMessage(ex.getMessage())
                .build();
        log.error("Generic Exception : {}", ex.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }

    /*   For a simple understanding, if validation happens at the controller/service layer by using the @Valid annotation,
         it generates MethodArgumentNotValidException. */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        log.error("validation error occurred in this fields :  {}", errorMap);
        return errorMap;
    }

    /*   Instead, if you do not validate using the @Valid annotation,
         an exception is raised by Hibernate at the JPA layer and generates ConstraintViolationException. */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .errorCode(GlobalErrorCode.GENERIC_ERROR)
                .errorMessage(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> handleOrderNotFoundException(StudentNotFoundException ex) {
        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorCode(GlobalErrorCode.ERROR_STUDENT_NOT_FOUND)
                .errorMessage(ex.getMessage())
                .build();
        log.error("Not Found Exception : {}", ex.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }


}
