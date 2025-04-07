package com.onyx.Exceptions;

public class InvoiceNotFoundException extends RuntimeException{
    public InvoiceNotFoundException(String description){
        super(description);
    }
}
