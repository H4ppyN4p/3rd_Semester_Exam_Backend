package com.example.backend.teacher.repository;

import com.example.backend.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long>
{
}
