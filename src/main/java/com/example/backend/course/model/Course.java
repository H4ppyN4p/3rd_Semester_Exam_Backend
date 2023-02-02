package com.example.backend.course.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

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
}
