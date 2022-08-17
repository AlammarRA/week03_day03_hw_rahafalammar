package com.example.week03_day03_hw_school_managment_rahafalammar.Service;
import com.example.week03_day03_hw_school_managment_rahafalammar.Jpa.Student;
import com.example.week03_day03_hw_school_managment_rahafalammar.Repository.StudentRepository;
import com.example.week03_day03_hw_school_managment_rahafalammar.Response.Message;
import com.example.week03_day03_hw_school_managment_rahafalammar.Response.apiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public void addStudent(Student newStudent){
        studentRepository.save(newStudent);
    }

    public void updateStudent(Student updateStudent , Long id){
        Student student = studentRepository.getById(id);
        student.setName(updateStudent.getName());
        student.setAge(updateStudent.getAge());
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        Student student = studentRepository.getById(id);
        studentRepository.delete(student);
    }

    public Student gtStudentById(Long id) {
        Student student = studentRepository.findStudentById(id);
        if(student==null){
            throw new apiException("not found");
        }
        return student;
    }


    public Student getStudentByName(String studentName){
        Student student = studentRepository.findStudentByName(studentName);
        if(student==null){
            throw new apiException("not found");
        }
        return student;
    }

    public List<Student> getStudentByMajor(String studentMajor){
        List<Student> students = studentRepository.findStudentByMajor(studentMajor);
        return students;
    }


    public List<Student> getStudentByAgeGreaterThanEqual(Integer studentAge){
        List<Student> students = studentRepository.getStudentByAgeGreaterThanEqual(studentAge);
        return students;
    }

}
