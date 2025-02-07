package com.demo.service.impl;

import com.demo.entity.Student;
import com.demo.repository.StdRepo;
import com.demo.service.StdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StdServiceImpl implements StdService {

    private final StdRepo stdRepo;

    public StdServiceImpl(StdRepo stdRepo) {
        this.stdRepo = stdRepo;
    }

    @Override
    public Student addStudent(Student std) {
        std.setId(UUID.randomUUID().toString());
        return stdRepo.save(std);
    }

    @Override
    public Student getStudentById(String id) {
        Optional<Student> byId = stdRepo.findById(id);
        return byId.orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return stdRepo.findAll();
    }

    @Override
    public void deleteStudent(String id) {
        stdRepo.delete(getStudentById(id));
    }

    @Override
    public Student updateStudent(String id, Student std) {
        Student oldStd = getStudentById(id);
        if (oldStd != null) {
            if(std.getPassword()!=null){
                oldStd.setPassword(std.getPassword());
            }
            if(std.getUserMail()!=null){
                oldStd.setUserMail(std.getUserMail());
            }
            return stdRepo.save(oldStd);
        } else {
            return null;
        }
    }
}
