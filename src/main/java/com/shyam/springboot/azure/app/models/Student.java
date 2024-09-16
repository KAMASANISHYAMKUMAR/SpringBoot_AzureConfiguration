package com.shyam.springboot.azure.app.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String studentName;
    private String studentEmail;
    private String studentAddress;
    private String studentPhone;


}
