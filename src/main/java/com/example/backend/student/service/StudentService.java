package com.example.backend.student.service;

import com.example.backend.course.model.Course;
import com.example.backend.student.model.Student;
import com.example.backend.student.repository.StudentRepository;
import com.example.backend.teacher.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //find single
    public Optional<Student> get(long id)
    {
        return studentRepository.findById(id);
    }

    //create
    public Student create(Student student)
    {
        return studentRepository.save(student);
    }


    //delete
    public boolean delete(Long id) {
        Optional<Student> optionalProduct = studentRepository.findById(id);
        if (optionalProduct.isEmpty()) return false;

        studentRepository.delete(optionalProduct.get());
        return true;
    }

}
