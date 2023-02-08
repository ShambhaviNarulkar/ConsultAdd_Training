package com.example.practice.service;

import com.example.practice.model.Student;
import com.example.practice.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    //Create New student details

    public String createStudent(Student student){
        if(this.studentRepo.existsById(student.getId())){
            return "Student already exists";
        }
        else{
            this.studentRepo.save(student);
            return "Student details are saved.";
        }
    }

    //get all student details

    public List<Student> getStudents(){
        return this.studentRepo.findAll();

    }

    //delete student
    public String deleteStudent(Integer id){
        if(this.studentRepo.existsById(id)) {
            this.studentRepo.deleteById(id);
            return "Student deleted";
        }
        return "Student not found";
    }



    //update student
    public String updateStudent(Student student){
        if(this.studentRepo.existsById(student.getId())){
            this.studentRepo.save(student);
            return "Student details are saved.";
        }
        else{
            return "Student does not exist";

        }
    }

    //get student by id
    public Student getStudentByID(int id){
        if(this.studentRepo.existsById(id)){
            return this.studentRepo.findById(id).get();
        }
        else{
            return null;
        }
    }

}
