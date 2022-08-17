package com.example.week03_day03_hw_school_managment_rahafalammar.Service;

import com.example.week03_day03_hw_school_managment_rahafalammar.Jpa.Student;
import com.example.week03_day03_hw_school_managment_rahafalammar.Jpa.Teacher;
import com.example.week03_day03_hw_school_managment_rahafalammar.Repository.TeacherRepository;
import com.example.week03_day03_hw_school_managment_rahafalammar.Response.apiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    public void addTeachers(Teacher newTeacher){
        teacherRepository.save(newTeacher);
    }

    public void updateTeachers(Teacher updateTeacher , Long id){
        Teacher teacher = teacherRepository.getById(id);
        teacher.setName(updateTeacher.getName());
        teacher.setSalary(updateTeacher.getSalary());
        teacherRepository.save(teacher);
    }

    public void deleteTeachers(Long id){
        Teacher teacher = teacherRepository.getById(id);
        teacherRepository.delete(teacher);
    }


    public Teacher gtTeacherById(Long id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new apiException("not found");
        }
        return teacher;
    }


    public List<Teacher> getTeacherBySalary(Integer teacherSalary){
        List<Teacher> teachers = teacherRepository.findTeacherBySalaryGreaterThanEqual(teacherSalary);
        return teachers;
    }
}

