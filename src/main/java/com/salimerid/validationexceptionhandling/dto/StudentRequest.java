package com.salimerid.validationexceptionhandling.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "build2")
@NoArgsConstructor
public class StudentRequest {
    @NotNull(message = "Name should not be null")
    private String name;

    @Email(message = "invalid email address")
    private String email;

   // @Pattern(regexp = "^(?:\\\\+88|88)?(01[3-9]\\\\d{8})$", message = "invalid mobile number")
    private String mobile;

    private String gender;

    @Min(13)
    @Max(70)
    private int age;

    @NotBlank
    private String className;

}
