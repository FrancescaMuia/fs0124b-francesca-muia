package com.example.eserciziog2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Entity with id " + id + " not found");
    }
}
