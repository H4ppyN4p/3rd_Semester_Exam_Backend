package com.example.backend.course.model;


import com.example.backend.student.model.Student;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(
            name = "students_assigned",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> assignedStudents = new ArrayList<>();

    public String name;
    public Date startDate;
    public Date endDate;
    public Double ectsPoints;
    public Double maxStudents;

    public Course(String name, Date startDate, Date endDate, Double ectsPoints, Double maxStudents)
    {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ectsPoints = ectsPoints;
        this.maxStudents = maxStudents;
    }

    public List<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void assignStudent(Student student) {
        assignedStudents.add(student);
    }
}
