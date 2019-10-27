package com.codematrix.jackson.services;


import com.codematrix.jackson.entity.Subject;
import com.codematrix.jackson.repositories.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class SubjectService {

    private SubjectRepository subjectRepository;

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> findOneById(Long id) {
        return subjectRepository.findById(id);
    }

    public void saveAll(List<Subject> subjects) {
        subjectRepository.saveAll(subjects);
    }

    public List<Subject> findByIdIn(List<Long> subjectIds) {
        return subjectRepository.findByIdIn(subjectIds);
    }
}
