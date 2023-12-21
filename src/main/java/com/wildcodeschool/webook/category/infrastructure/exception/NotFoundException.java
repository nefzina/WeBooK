package com.wildcodeschool.webook.category.infrastructure.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Object not found");
    }
}
