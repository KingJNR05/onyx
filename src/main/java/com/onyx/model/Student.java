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
    private String middle_name;
    private String nationality;
    private String home_language;
    private String race;
    private String religion;

    private String gender;
    private String disability;

    private String siblings_in_school;

    private int grade;
    private LocalDate date_of_birth;
    private String guardian_name;
    private String guardian_contact;


    public Student() {}


    public Student(Long id, String first_name, String last_name,
                   String middle_name, String nationality,
                   String home_language, String race, String religion,
                   String gender, String disability, String siblings_in_school,
                   int grade, LocalDate date_of_birth, String guardian_name,
                   String guardian_contact
    ) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.nationality = nationality;
        this.home_language = home_language;
        this.race = race;
        this.religion = religion;
        this.gender = gender;
        this.disability = disability;
        this.siblings_in_school = siblings_in_school;
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

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHome_language() {
        return home_language;
    }

    public void setHome_language(String home_language) {
        this.home_language = home_language;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getSiblings_in_school() {
        return siblings_in_school;
    }

    public void setSiblings_in_school(String siblings_in_school) {
        this.siblings_in_school = siblings_in_school;
    }
}
