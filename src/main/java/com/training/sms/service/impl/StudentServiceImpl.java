package com.training.sms.service.impl;

import com.training.sms.dto.StudentDto;
import com.training.sms.entity.Student;
import com.training.sms.exception.ResourceNotFoundException;
import com.training.sms.mapper.StudentMapper;
import com.training.sms.repository.StudentRepository;
import com.training.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// this annotation tells the spring container to create the spring bean for this class
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist with given id : " + studentId));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((s) -> StudentMapper.mapToStudentDto(s))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist with given id : " + studentId));

        // update student JPA entity fields
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());

        // save() perform both add/update operation
        Student updatedStudentObj = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist with given id : " + studentId));

        studentRepository.deleteById(studentId);
    }


}
