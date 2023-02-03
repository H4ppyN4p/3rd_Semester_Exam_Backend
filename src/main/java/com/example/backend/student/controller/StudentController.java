package com.example.backend.student.controller;

import com.example.backend.course.model.Course;
import com.example.backend.student.model.Student;
import com.example.backend.student.service.StudentService;
import com.example.backend.teacher.model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/students")
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll()
    {
        return studentService.GetAll();
    }

    @GetMapping("/{id}")
    public Student find(@PathVariable("id") Long id)
    {
        Optional<Student> student = studentService.get(id);

        return student.get();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.create(student);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id)
    {
        boolean delete = studentService.delete(id);
        return ResponseEntity.ok().body(delete);
    }
}
