package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    @NotBlank(message = "Name is Required")
    @Size(max = 100, message = "Name cannot exceed 100 Characters")
    private String name;

    @NotBlank(message = "Eamil is Required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is Required")
    private String address;

    @NotBlank(message = "DOB is required")
    private String dateOfBirth;

    @NotBlank(message = "Registered date is required")
    private String registeredDate;
}
