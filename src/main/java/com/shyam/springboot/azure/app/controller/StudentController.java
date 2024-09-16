package com.shyam.springboot.azure.app.controller;

import com.shyam.springboot.azure.app.models.Student;
import com.shyam.springboot.azure.app.services.StudentService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService  studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return this.studentService.saveStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student  getStudentById(@PathVariable("id") int id) {
        return this.studentService.getStudentById(id);
    }

}
