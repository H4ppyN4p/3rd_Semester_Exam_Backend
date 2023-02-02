package com.example.backend.course.controller;

import com.example.backend.course.model.Course;
import com.example.backend.course.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        //return ResponseEntity.ok().body(courseService.getAll());
    }
}
