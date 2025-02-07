package com.demo.service;

import com.demo.entity.Student;

import java.util.List;

public interface StdService {
    Student addStudent(Student std);
    Student getStudentById(String id);
    List<Student> getAllStudents();
    void deleteStudent(String id);
    Student updateStudent(String id,Student std);

}
