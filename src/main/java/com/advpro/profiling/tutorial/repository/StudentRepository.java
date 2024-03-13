package com.advpro.profiling.tutorial.repository;

import com.advpro.profiling.tutorial.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author muhammad.khadafi
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT string_agg(student.name, ', ') FROM Student student")
    String getJoinedStudentNames();

    @Query("SELECT student FROM Student student ORDER BY student.gpa DESC LIMIT 1")
    Optional<Student> findHighestGpaStudent();
}