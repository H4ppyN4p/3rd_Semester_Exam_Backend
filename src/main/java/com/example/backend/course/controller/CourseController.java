package com.example.backend.course.controller;

import com.example.backend.course.model.Course;
import com.example.backend.course.repository.CourseRepository;
import com.example.backend.course.service.CourseService;
import com.example.backend.student.model.Student;
import com.example.backend.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/courses")
public class CourseController
{
    private final CourseService courseService;
    private final StudentService studentService;



    public CourseController(CourseService courseService, StudentService studentService)
    {
        this.courseService = courseService;
        this.studentService = studentService;
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

    //handles the relationship between courses and students

    @PutMapping("/{courseId}/students/{studentId}")
    Course assignStudentToSubject(@PathVariable Long courseId, @PathVariable Long studentId)
    {
        Course course = courseService.get(courseId).get();
        Student student = studentService.get(studentId).get();
        course.assignStudent(student);
        return courseService.saveCourseWithStudent(course);
    }





}
