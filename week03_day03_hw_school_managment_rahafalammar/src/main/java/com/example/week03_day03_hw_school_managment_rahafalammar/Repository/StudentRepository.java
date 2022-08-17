package com.example.week03_day03_hw_school_managment_rahafalammar.Repository;

import com.example.week03_day03_hw_school_managment_rahafalammar.Jpa.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findStudentByName(String studentName);

    List<Student> findStudentByMajor(String studentMajor);

    List<Student> getStudentByAgeGreaterThanEqual(Integer studentAge);

    Student findStudentById(Long id);
}
