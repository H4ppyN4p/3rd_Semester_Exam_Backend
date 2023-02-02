package com.example.backend.teacher.model;

import com.example.backend.course.model.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Course> assignedCourses = new ArrayList<>();

    public String name;
    public String email;

    public Teacher(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }
}
