package com.taxi.uber.advices;

import com.taxi.uber.exceptions.ResourceNotFoundException;
import com.taxi.uber.exceptions.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception){
        ApiError apiError=ApiError.builder().status(HttpStatus.BAD_REQUEST).message(exception.getMessage()).build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException){
        ApiError apiError=ApiError.builder().status(HttpStatus.NOT_FOUND).message(resourceNotFoundException.getMessage()).build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse<?>> handleUserAlreadyExistException(UserAlreadyExistException userAlreadyExistException){
        ApiError apiError=ApiError.builder().status(HttpStatus.CONFLICT).message(userAlreadyExistException.getMessage()).build();
        return buildErrorResponseEntity(apiError);
    }

    private ResponseEntity buildErrorResponseEntity(ApiError apiError){
        return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }
}
