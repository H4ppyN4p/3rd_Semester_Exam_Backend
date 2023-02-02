package com.example.backend.student.service;

import com.example.backend.student.model.Student;
import com.example.backend.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    //read
    public List<Student> GetAll()
    {
        return studentRepository.findAll();
    }

    //create
    public Student create(Student student)
    {
        return studentRepository.save(student);
    }
}
