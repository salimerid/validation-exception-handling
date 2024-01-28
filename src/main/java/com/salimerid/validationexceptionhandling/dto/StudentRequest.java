package com.salimerid.validationexceptionhandling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String className;

}
