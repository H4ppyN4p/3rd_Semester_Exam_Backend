package com.example.backend.teacher.controller;

import com.example.backend.teacher.model.Teacher;
import com.example.backend.teacher.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/teachers")
public class TeacherController
{
    public final TeacherService teacherService;

    public TeacherController(TeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> findAll()
    {
        return teacherService.getAll();
    }

    @GetMapping("/{id}")
    public Teacher find(@PathVariable("id") Long id)
    {
        Optional<Teacher> teacher = teacherService.get(id);

        return teacher.get();
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher)
    {
        return teacherService.create(teacher);
    }
}
