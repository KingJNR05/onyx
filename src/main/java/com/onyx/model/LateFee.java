package com.onyx.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class LateFee {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @Column(nullable = false)
    private BigDecimal amount;

    private LocalDate applied_date = LocalDate.now();


    public LateFee(Long id, BigDecimal amount, LocalDate applied_date) {
        this.id = id;

        this.amount = amount;
        this.applied_date = applied_date;
    }

    public LateFee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getApplied_date() {
        return applied_date;
    }

    public void setApplied_date(LocalDate applied_date) {
        this.applied_date = applied_date;
    }
}
