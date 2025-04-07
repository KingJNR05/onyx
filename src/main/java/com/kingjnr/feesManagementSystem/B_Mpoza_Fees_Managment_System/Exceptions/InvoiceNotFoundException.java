package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.Exceptions;

public class InvoiceNotFoundException extends RuntimeException{
    public InvoiceNotFoundException(String description){
        super(description);
    }
}
