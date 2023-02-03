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

    //find by name
    public List<Teacher> findByName(String name) {
        return teacherRepository.findByName(name);
    }

    //create
    public Teacher create(Teacher teacher)
    {
        return teacherRepository.save(teacher);
    }

    //delete
    public boolean delete(Long id) {
        Optional<Teacher> optionalProduct = teacherRepository.findById(id);
        if (optionalProduct.isEmpty()) return false;

        teacherRepository.delete(optionalProduct.get());
        return true;
    }

    //update teacher
    public Teacher updateTeacher(Teacher teacher)
    {
        Teacher myTeacher = teacherRepository.findById(teacher.getId()).get();
        if (myTeacher != null)
        {
            myTeacher.setName(teacher.getName());
            myTeacher.setEmail(teacher.getEmail());
        }

        return teacherRepository.save(myTeacher);
    }



}
