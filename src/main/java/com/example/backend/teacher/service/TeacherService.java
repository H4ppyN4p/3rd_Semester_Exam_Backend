package com.example.backend.teacher.service;

import com.example.backend.teacher.model.Teacher;
import com.example.backend.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService
{
    @Autowired
    private TeacherRepository teacherRepository;

    //read
    public List<Teacher> getAll()
    {
       return teacherRepository.findAll();
    }

    //find single
    public Optional<Teacher> get(Long id)
    {
        return teacherRepository.findById(id);
    }

    //create
    public Teacher create(Teacher teacher)
    {
        return teacherRepository.save(teacher);
    }
}
