package com.onyx.service;

import com.onyx.model.Student;
import com.onyx.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public Student addStudent(Student student){
        return repo.save(student);
    }

    public Student getStudent(Long studentId) {
       return repo.findById(studentId).orElse(new Student());
    }

    public void deleteStudent(Long studentId) {
       repo.deleteById(studentId);
    }



}
