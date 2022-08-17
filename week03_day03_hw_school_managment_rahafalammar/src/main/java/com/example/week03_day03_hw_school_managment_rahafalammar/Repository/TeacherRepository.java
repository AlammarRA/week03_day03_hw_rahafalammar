package com.example.week03_day03_hw_school_managment_rahafalammar.Repository;

import com.example.week03_day03_hw_school_managment_rahafalammar.Jpa.Student;
import com.example.week03_day03_hw_school_managment_rahafalammar.Jpa.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Teacher findTeacherById(Long id);

    List<Teacher> findTeacherBySalaryGreaterThanEqual(Integer teacherSalary);
}
