package com.practice.learningspringdatajpa.repository;

import com.practice.learningspringdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    // Native
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    public Student findStudentByEmailAddressNative(String email);

    // Native Named Parameter
    @Query(
            value = "select * from tbl_student s where s.email_address =:email",
            nativeQuery = true
    )
    public Student findStudentByEmailAddressNativeNamedParam(@Param("email") String email);


    @Modifying  // we use it whenever we are using custom query methods
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    public int updateStudentNameByEmailAddress(String firstName, String email);
}
