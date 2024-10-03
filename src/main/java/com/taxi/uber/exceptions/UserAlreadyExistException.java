package com.taxi.uber.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message){
        super(message);
    }
}
