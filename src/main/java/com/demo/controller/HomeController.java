package com.demo.controller;

import com.demo.entity.Student;
import com.demo.service.StdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    private final StdService stdService;

    public HomeController(StdService stdService) {
        this.stdService = stdService;
    }

    @GetMapping("/")
    public String welcome() {
        log.info("Welcome to home Page");
        return "Welcome to home Page";
    }

    @GetMapping("/user/data")
    public Student userData() {
        return new Student(UUID.randomUUID().toString(), "Deepak@gmail.com", "deep@1234");
    }

    @PostMapping("/user/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student std) {
        Student student = stdService.addStudent(std);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/user/")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> student = stdService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") String id) {
        Student student = stdService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(student);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") String id) {
        stdService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Record Deleted successfully");
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
        Student std = stdService.updateStudent(id, student);
        return ResponseEntity.status(HttpStatus.OK).body(std);
    }

}
