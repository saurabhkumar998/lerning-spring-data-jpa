package com.practice.learningspringdatajpa.repository;

import com.practice.learningspringdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    @Query("select s from Student s where s.emailId = ?1")
    public Student findStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String findStudentFirstNameByEmailAddress(String email);

}
