package com.onyx.controllers;

import com.onyx.model.Student;
import com.onyx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("bmpoza")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @GetMapping("student/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId){
        return service.getStudent(studentId);

    }


    @PutMapping("student/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable Long studentId){
        return service.updateStudent(student,studentId);
    }

    @DeleteMapping("student/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId){
        return service.deleteStudent(studentId);
    }


}
