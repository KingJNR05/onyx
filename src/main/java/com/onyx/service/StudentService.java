package com.onyx.service;

import com.onyx.Exceptions.StudentNotFoundException;
import com.onyx.model.Student;
import com.onyx.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public ResponseEntity<Student> addStudent(Student student) {
        if (student != null) {
            repo.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }

    public Student getStudent(Long studentId) {
        return repo.findById(studentId).orElseThrow(()-> new StudentNotFoundException("Student not found"));
    }

    public ResponseEntity<Student> deleteStudent(Long studentId) {
        repo.deleteById(studentId);

        if(repo.findById(studentId).isPresent())
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        else
            return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Student> updateStudent(Student student, Long studentId){

        Student updatedStudent =  repo.findById(studentId).orElseThrow(()-> new StudentNotFoundException("Student not Found"));

        updatedStudent.setId(studentId);

        if(student.getFirst_name() != null)
            updatedStudent.setFirst_name(student.getFirst_name());

        if(student.getLast_name() != null)
            updatedStudent.setLast_name(student.getLast_name());

        if(student.getGrade() != 0)
            updatedStudent.setGrade(student.getGrade());

        if (student.getDate_of_birth() != null)
            updatedStudent.setDate_of_birth(student.getDate_of_birth());

        if (student.getGuardian_name() != null)
            updatedStudent.setGuardian_name(student.getGuardian_name());

        if (student.getGuardian_contact() != null)
            updatedStudent.setGuardian_contact(student.getGuardian_contact());


        repo.save(updatedStudent);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }



}
