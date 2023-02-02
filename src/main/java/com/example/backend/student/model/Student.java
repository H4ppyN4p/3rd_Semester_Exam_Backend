package com.example.backend.student.model;

import com.example.backend.course.model.Course;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToMany(mappedBy = "assignedStudents")
    private Set<Course> coursesToAttend;

    public String name;
    public String email;

    public Student(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public void addCourse(Course course)
    {
        coursesToAttend.add(course);
    }

    public Set<Course> getCoursesToAttend() {
        return coursesToAttend;
    }
}
