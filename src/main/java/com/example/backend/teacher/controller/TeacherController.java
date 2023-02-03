package com.example.backend.teacher.controller;

import com.example.backend.teacher.model.Teacher;
import com.example.backend.teacher.service.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/name")
    public ResponseEntity<List<Teacher>> getTeachersByName(@RequestParam String name)
    {
        return new ResponseEntity<List<Teacher>>(teacherService.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher)
    {
        return teacherService.create(teacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id)
    {
        boolean delete = teacherService.delete(id);
        return ResponseEntity.ok().body(delete);
    }

    @PostMapping("/update")
    public Teacher updateTeacherName(@RequestBody Teacher teacher)
    {
        return teacherService.updateTeacher(teacher);
    }

}
