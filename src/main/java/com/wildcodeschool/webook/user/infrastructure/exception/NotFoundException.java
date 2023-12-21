package com.wildcodeschool.webook.user.infrastructure.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Object not found");
    }
}
