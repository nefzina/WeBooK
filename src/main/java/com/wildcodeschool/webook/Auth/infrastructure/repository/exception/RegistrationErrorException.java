package com.wildcodeschool.webook.Auth.infrastructure.repository.exception;

public class RegistrationErrorException extends RuntimeException{
    public RegistrationErrorException(String message) {
        super(message);
    }
}
