package com.salimerid.validationexceptionhandling.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String className;
}
