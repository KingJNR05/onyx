package com.onyx.service;

import com.onyx.Exceptions.StudentNotFoundException;
import com.onyx.model.Student;
import com.onyx.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public ResponseEntity<String> addStudent(Student student) {
        if (student != null) {
            repo.save(student);
            return new ResponseEntity<>("Student Saved Successfully", HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>("Student Save Failed",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Student> getStudent(Long studentId) {
        Student student = repo.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudent(Long studentId) {
        Optional<Student> student = repo.findById(studentId);

        if (student.isPresent()) {
            repo.deleteById(studentId);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Student> updateStudent(Student student, Long studentId){

        Student updatedStudent =  repo.findById(studentId).orElseThrow(()-> new StudentNotFoundException("Student not Found"));

        updatedStudent.setId(studentId);

        if(student.getFirst_name() != null)
            updatedStudent.setFirst_name(student.getFirst_name());

        if(student.getLast_name() != null)
            updatedStudent.setLast_name(student.getLast_name());

        if(student.getMiddle_name() != null)
            updatedStudent.setMiddle_name(student.getMiddle_name());

        if(student.getGrade() != 0)
            updatedStudent.setGrade(student.getGrade());

        if (student.getDate_of_birth() != null)
            updatedStudent.setDate_of_birth(student.getDate_of_birth());

        if (student.getGuardian_name() != null)
            updatedStudent.setGuardian_name(student.getGuardian_name());

        if (student.getGuardian_contact() != null)
            updatedStudent.setGuardian_contact(student.getGuardian_contact());

        if (student.getDisability() != null)
            updatedStudent.setDisability(student.getDisability());

        if (student.getGender() != null)
            updatedStudent.setGender(student.getGender());

        if (student.getHome_language() != null)
            updatedStudent.setHome_language(student.getHome_language());

        if (student.getRace() != null)
            updatedStudent.setRace(student.getRace());

        if (student.getReligion() != null)
            updatedStudent.setReligion(student.getReligion());

        if (student.getNationality() != null)
            updatedStudent.setNationality(student.getNationality());

        if (student.getSiblings_in_school() != null)
            updatedStudent.setSiblings_in_school(student.getSiblings_in_school());

        repo.save(updatedStudent);
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }



}
