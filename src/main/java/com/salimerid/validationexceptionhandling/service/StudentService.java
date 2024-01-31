package com.salimerid.validationexceptionhandling.service;

import com.salimerid.validationexceptionhandling.dto.StudentRequest;
import com.salimerid.validationexceptionhandling.model.Student;
import com.salimerid.validationexceptionhandling.repository.StudentRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(StudentRequest request) {
        Student student = Student
                .build(0, request.getName(), request.getEmail(), request.getMobile(),
                        request.getGender(), request.getAge(), request.getClassName());
        return repository.save(student);
    }

    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    public Student getStudent(int id) {
        Student student = repository.findById(id).orElse(new Student());
        return student;
    }

}
