package com.onyx.Exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String description){
        super(description);
    }
}
