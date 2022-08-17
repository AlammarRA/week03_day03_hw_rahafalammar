package com.example.week03_day03_hw_school_managment_rahafalammar.Controller;

import com.example.week03_day03_hw_school_managment_rahafalammar.Jpa.Student;
import com.example.week03_day03_hw_school_managment_rahafalammar.Jpa.Teacher;
import com.example.week03_day03_hw_school_managment_rahafalammar.Response.Message;
import com.example.week03_day03_hw_school_managment_rahafalammar.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public ResponseEntity<List> getTeachers(){
        List<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public ResponseEntity<Message> addTeacher(@RequestBody @Valid Teacher newTeacher){
        teacherService.addTeachers(newTeacher);
        return ResponseEntity.status(200).body(new Message("New Teacher added",200));
    }

    @RequestMapping(path = "/update/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Message> updateTeacher(@RequestBody @Valid Teacher teacher, @PathVariable Long id){
        teacherService.updateTeachers(teacher,id);
        return ResponseEntity.status(200).body(new Message("Teacher data updated!",200));
    }

    @RequestMapping(path = "/delete/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Message> deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeachers(id);
        return ResponseEntity.status(200).body(new Message("Teacher deleted!",200));
    }


    @RequestMapping(path = "/get_teacher_by_id" , method = RequestMethod.GET)
    public ResponseEntity<Teacher> getTeacherById(@RequestParam Long id){
        Teacher teacher = teacherService.gtTeacherById(id);
        return ResponseEntity.status(200).body(teacher);
    }

    @RequestMapping(path = "/get_teacher_by_salary" , method = RequestMethod.GET)
    public ResponseEntity<List> getTeacherBySalary(@RequestParam Integer salary){
        List<Teacher> teachers = teacherService.getTeacherBySalary(salary);
        return ResponseEntity.status(200).body(teachers);
    }

}
