package com.training.sms.mapper;

import com.training.sms.dto.StudentDto;
import com.training.sms.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
    }
}
