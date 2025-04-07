package com.onyx.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private int grade;
    private LocalDate date_of_birth;
    private String guardian_name;
    private String guardian_contact;


    public Student() {}

    public Student(Long id, String first_name, String last_name, int grade,
                   LocalDate date_of_birth, String guardian_name, String guardian_contact) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.grade = grade;
        this.date_of_birth = date_of_birth;
        this.guardian_name = guardian_name;
        this.guardian_contact = guardian_contact;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGuardian_name() {
        return guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
    }

    public String getGuardian_contact() {
        return guardian_contact;
    }

    public void setGuardian_contact(String guardian_contact) {
        this.guardian_contact = guardian_contact;
    }
}
