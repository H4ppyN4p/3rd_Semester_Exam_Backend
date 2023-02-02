package com.example.backend.course.service;

import com.example.backend.course.model.Course;
import com.example.backend.course.repository.CourseRepository;
import com.example.backend.student.model.Student;
import com.example.backend.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Optional;

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

    //get single
    public Optional<Course> get(long id)
    {
        return courseRepository.findById(id);
    }

    //create
    public Course create(Course course)
    {
        return courseRepository.save(course);
    }

    public Course saveCourseWithStudent(Course course) {
        return  courseRepository.save(course);
    }
}
