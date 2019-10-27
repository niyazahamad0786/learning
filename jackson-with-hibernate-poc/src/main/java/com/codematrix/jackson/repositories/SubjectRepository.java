package com.codematrix.jackson.repositories;

import com.codematrix.jackson.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByIdIn(List<Long> subjects);
}
