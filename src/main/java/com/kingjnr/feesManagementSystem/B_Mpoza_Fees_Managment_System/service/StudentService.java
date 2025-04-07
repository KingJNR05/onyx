package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.service;

import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.model.Student;
import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.repository.StudentRepository;
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
