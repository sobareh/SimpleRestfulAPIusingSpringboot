package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student stu) {
        return studentService.createStudent(stu);
    }

    @RequestMapping(value="/students", method=RequestMethod.GET)
    public List<Student> readStudents() {
        return studentService.getStudents();
    }

    @RequestMapping(value="/students/{empId}", method=RequestMethod.PUT)
    public Student readStudents(@PathVariable(value = "empId") Long id, @RequestBody Student empDetails) {
        return studentService.updateStudent(id, empDetails);
    }

    @RequestMapping(value="/students/{empId}", method=RequestMethod.DELETE)
    public void deleteStudent(@PathVariable(value = "empId") Long id) {
        studentService.deleteStudent(id);
    }
}
