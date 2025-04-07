package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.controllers;

import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.model.Student;
import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bmpoza")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("student")
    public String addStudent(@RequestBody Student student){
         Student student1 = service.addStudent(student);
         if(student1 != null)
             return "success";
         else
             return "failed";
    }

    @GetMapping("student/{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        return service.getStudent(studentId);
    }

    @PutMapping("student")
    public Student updateStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @DeleteMapping("student/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
         service.deleteStudent(studentId);
    }

}
