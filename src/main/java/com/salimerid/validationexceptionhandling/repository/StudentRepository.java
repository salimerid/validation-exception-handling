package com.salimerid.validationexceptionhandling.repository;

import com.salimerid.validationexceptionhandling.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
