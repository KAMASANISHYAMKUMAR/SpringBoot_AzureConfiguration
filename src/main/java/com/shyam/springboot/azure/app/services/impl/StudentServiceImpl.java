package com.shyam.springboot.azure.app.services.impl;

import com.shyam.springboot.azure.app.models.Student;
import com.shyam.springboot.azure.app.repository.StudentRepository;
import com.shyam.springboot.azure.app.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return this.studentRepository.findById(id).orElse(null);
    }
}
