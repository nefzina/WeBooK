package com.wildcodeschool.webook.book.infrastructure.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Object not found");
    }
}