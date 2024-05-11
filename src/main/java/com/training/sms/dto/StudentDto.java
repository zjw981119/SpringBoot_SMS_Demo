package com.training.sms.dto;

import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// use dto class to transfer the data between client and server
public class StudentDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
