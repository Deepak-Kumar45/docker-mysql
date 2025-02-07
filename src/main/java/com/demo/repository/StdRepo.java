package com.demo.repository;

import com.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StdRepo extends JpaRepository<Student,String> {
}
