package com.example.backend.course.controller;

import com.example.backend.course.model.Course;
import com.example.backend.course.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/courses")
public class CourseController
{
    private final CourseService courseService;

    public CourseController(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> findAll()
    {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course find(@PathVariable("id") Long id)
    {
        Optional<Course> course = courseService.get(id);

        return course.get();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course)
    {
        return courseService.create(course);
    }

}
