package com.salimerid.validationexceptionhandling.controller;

import com.salimerid.validationexceptionhandling.dto.StudentRequest;
import com.salimerid.validationexceptionhandling.model.Student;
import com.salimerid.validationexceptionhandling.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody @Valid StudentRequest request) {
        return new ResponseEntity<>(service.saveStudent(request), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(service.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        return ResponseEntity.ok(service.getStudent(id));
    }
}
