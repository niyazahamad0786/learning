package com.codematrix.jackson.repositories;

import com.codematrix.jackson.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByName(String name);
}
