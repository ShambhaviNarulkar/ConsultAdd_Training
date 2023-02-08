package com.example.practice.controller;

import com.example.practice.model.Student;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/allstudents")
    public List<Student> getAllStudents(){
        return this.studentService.getStudents();
    }

    @PostMapping("/createstudent")
    public String createStudent(@RequestBody Student student){
        return this.studentService.createStudent(student);
    }

    //delete
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable String id){
        return this.studentService.deleteStudent(Integer.parseInt(id));
    }

    //update
    @PutMapping("/student/{id}")
    public String updateStudent(@RequestBody Student student){
        return this.studentService.updateStudent(student);
    }

    //getbyid
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable String id){
        return this.studentService.getStudentByID(Integer.parseInt(id));
    }


}
