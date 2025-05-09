package com.onyx.model;

import java.math.BigDecimal;

public class FeePaymentDetails {
    private Long invoice_id;
    private Long student_id;
    private BigDecimal amount_paid;
    private PaymentMethod Payment_method;

    public FeePaymentDetails(Long invoice_id, Long student_id, BigDecimal amount_paid, PaymentMethod payment_method) {
        this.invoice_id = invoice_id;
        this.student_id = student_id;
        this.amount_paid = amount_paid;
        this.Payment_method = payment_method;
    }

    public FeePaymentDetails(){

    }

    public Long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public BigDecimal getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(BigDecimal amount_paid) {
        this.amount_paid = amount_paid;
    }

    public PaymentMethod getPayment_method() {
        return Payment_method;
    }

    public void setPayment_method(PaymentMethod payment_method) {
        Payment_method = payment_method;
    }


}
