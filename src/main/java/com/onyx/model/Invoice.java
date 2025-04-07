package com.onyx.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    private String month;
    private int year;
    private BigDecimal amountDue;
    private BigDecimal discount = BigDecimal.ZERO;
    private BigDecimal finalAmountDue;

    @Column(nullable = false, columnDefinition = "DEFAULT 0.00")
    private BigDecimal creditAmount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InvoiceStatus status = InvoiceStatus.Pending;

    private LocalDate dueDate;

    public Invoice() {}

    public Invoice(Student student, String month, int year, BigDecimal amountDue, BigDecimal discount, BigDecimal finalAmountDue, InvoiceStatus status, LocalDate dueDate, BigDecimal creditAmount) {
        this.student = student;
        this.month = month;
        this.year = year;
        this.amountDue = amountDue;
        this.discount = discount;
        this.finalAmountDue = finalAmountDue;
        this.status = status;
        this.dueDate = dueDate;
        this.creditAmount = creditAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getFinalAmountDue() {
        return finalAmountDue;
    }

    public void setFinalAmountDue(BigDecimal finalAmountDue) {
        this.finalAmountDue = finalAmountDue;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }
}
