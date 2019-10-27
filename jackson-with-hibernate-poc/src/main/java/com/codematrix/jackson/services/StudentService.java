package com.codematrix.jackson.services;

import com.codematrix.jackson.entity.Student;
import com.codematrix.jackson.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(isolation = Isolation.READ_COMMITTED)
public class StudentService {

    private StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findOneById(Long id) {
        return studentRepository.findById(id);
    }

    public void saveAll(List<Student> students) {
        studentRepository.saveAll(students);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findOneWithSubject(Student student) {
        Student dbStudent = studentRepository.findById(student.getId()).get();
        dbStudent.getSubjects().size();
        return dbStudent;
    }
}
