package com.example.backend.course.service;

import com.example.backend.course.model.Course;
import com.example.backend.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService
{
    @Autowired
    private CourseRepository courseRepository;

    //read
    public List<Course> getAll()
    {
        return courseRepository.findAll();
    }

    //create
    public Course create(Course course)
    {
        return courseRepository.save(course);
    }
}
