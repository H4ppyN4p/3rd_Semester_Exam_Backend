package com.example.backend;

import com.example.backend.course.model.Course;
import com.example.backend.course.service.CourseService;
import com.example.backend.student.model.Student;
import com.example.backend.student.service.StudentService;
import com.example.backend.teacher.model.Teacher;
import com.example.backend.teacher.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class BackendApplication
{

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public static ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner importDummyCourses(CourseService service)
    {
        LocalDate localDateStart = LocalDate.of(2021, 01, 01);
        LocalDate localDateEnd = LocalDate.of(2021, 01, 06);

        return (args) -> {
            service.create(new Course("Danish", Date.valueOf(localDateStart), Date.valueOf(localDateEnd), 10.0, 30.0));
            service.create(new Course("English", Date.valueOf(localDateStart), Date.valueOf(localDateEnd), 10.0, 30.0));
            service.create(new Course("Spanish", Date.valueOf(localDateStart), Date.valueOf(localDateEnd), 10.0, 30.0));
        };
    }

    @Bean
    public CommandLineRunner importDummyStudents(StudentService service)
    {
        return (args) -> {
            service.create(new Student("Simon", "Simon@email.com"));
            service.create(new Student("Jenna", "Jenna@email.com"));
            service.create(new Student("Tommy", "Tommy@email.com"));
        };
    }

    @Bean
    public CommandLineRunner importDummyTeachers(TeacherService service)
    {
        return (args) -> {
            service.create(new Teacher("TeacherJens", "Jens@teacher.email.com"));
            service.create(new Teacher("TeacherJames", "James@teachere.mail.com"));
            service.create(new Teacher("TeacherVivianne", "Vivianne@teacher.email.com"));
        };
    }

}
