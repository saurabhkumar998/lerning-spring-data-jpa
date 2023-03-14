package com.practice.learningspringdatajpa.repository;

import com.practice.learningspringdatajpa.entity.Guardian;
import com.practice.learningspringdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest // this will impact our database as it updates the db permanently
//@DataJpaTest  // ideally we should use this to test the repository as it flushes all the changes at the end, i.e. won't impact the db
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .emailId("saurabh@gmail.com")
                .firstName("saurabh")
                .lastName("kumar")
                //.guardianEmail("rajesh@gmail.com")
                //.guardianName("Rajesh Kumar")
                //.guardianMobile("9708281081")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Rajesh Kumar")
                .email("rajesh@gmail.com")
                .mobile("9708281081")
                .build();

        Student student = Student.builder()
                .emailId("saumya@gmail.com")
                .firstName("saumya")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("Student List : " + students);
    }

}