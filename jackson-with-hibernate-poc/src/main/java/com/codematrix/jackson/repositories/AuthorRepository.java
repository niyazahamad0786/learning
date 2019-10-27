package com.codematrix.jackson.repositories;

import com.codematrix.jackson.entity.Author;
import com.codematrix.jackson.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByName(String name);

    List<Author> findBySubjects(List<Subject> subject);
}
