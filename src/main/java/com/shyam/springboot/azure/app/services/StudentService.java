package com.shyam.springboot.azure.app.services;

import com.shyam.springboot.azure.app.models.Student;

public interface StudentService {

    Student saveStudent(Student student);
    Student getStudentById(Integer id);
}
