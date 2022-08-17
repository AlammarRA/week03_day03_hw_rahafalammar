package com.example.week03_day03_hw_school_managment_rahafalammar.Controller;

import com.example.week03_day03_hw_school_managment_rahafalammar.Jpa.Student;
import com.example.week03_day03_hw_school_managment_rahafalammar.Response.Message;
import com.example.week03_day03_hw_school_managment_rahafalammar.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/student")
public class StudentController {

    @Autowired
    private StudentService studentServices;


    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public ResponseEntity<List> getAllStudent(){
        List<Student> students = studentServices.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public ResponseEntity<Message> addNewStudent(@RequestBody @Valid Student newStudent){
        studentServices.addStudent(newStudent);
        return ResponseEntity.status(200).body(new Message("New Student added",200));
    }

    @RequestMapping(path = "/update/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Message> updateStudent(@RequestBody @Valid Student updateStudent, @PathVariable Long id){
        studentServices.updateStudent(updateStudent,id);
        return ResponseEntity.status(200).body(new Message("Student data updated!",200));
    }

    @RequestMapping(path = "/delete/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Message> deleteStudent(@PathVariable Long id){
        studentServices.deleteStudent(id);
        return ResponseEntity.status(200).body(new Message("Student deleted!",200));
    }

    @RequestMapping(path = "/student_by_id" , method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@RequestParam Long id){
        Student student = studentServices.gtStudentById(id);
        return ResponseEntity.status(200).body(student);
    }

    @RequestMapping(path = "/student_by_name" , method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentByName(@RequestParam String name){
        Student student = studentServices.getStudentByName(name);
        return ResponseEntity.status(200).body(student);
    }

    @RequestMapping(path = "/student_by_major" , method = RequestMethod.GET)
    public ResponseEntity getStudentByMajor(@RequestParam String major){
        List<Student> students = studentServices.getStudentByMajor(major);
        return ResponseEntity.status(200).body(students);
    }

    @RequestMapping(path = "/student_by_age" , method = RequestMethod.GET)
    public ResponseEntity getStudentByMajor(@RequestParam Integer age){
        List<Student> students = studentServices.getStudentByAgeGreaterThanEqual(age);
        return ResponseEntity.status(200).body(students);
    }

}