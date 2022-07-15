package com.example.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import java.util.List;

@Service
public class StudentService {

    @Autowired
        StudentRepository stuRepository;

    public Student createStudent(Student stu) {
        return stuRepository.save(stu);
    }

    public List<Student> getStudents() {
        return stuRepository.findAll();
    }

    public void deleteStudent(Long stuId) {
        stuRepository.deleteById(stuId);
    }

    public Student updateStudent(Long stuId, Student studentDetails) {
        Student stu = stuRepository.findById(stuId).get();
        stu.setName(studentDetails.getName());
        stu.setStudentId(studentDetails.getStudentId());
        stu.setEmail(studentDetails.getEmail());

        return stuRepository.save(stu);
    }
}
