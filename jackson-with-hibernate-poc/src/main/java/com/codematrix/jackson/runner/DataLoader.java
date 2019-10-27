package com.codematrix.jackson.runner;

import com.codematrix.jackson.entity.Author;
import com.codematrix.jackson.entity.Student;
import com.codematrix.jackson.entity.Subject;
import com.codematrix.jackson.services.AuthorService;
import com.codematrix.jackson.services.StudentService;
import com.codematrix.jackson.services.SubjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//@Component
@Slf4j
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private StudentService studentService;
    private AuthorService authorService;
    private SubjectService subjectService;


    @Override
    public void run(String... args) throws Exception {
        loadStudents();
        loadSubjects();
        loadAuthors();
        mapSubjectToAuthor();
        mapSubjectToStudent();
    }

    private void loadStudents() {
        List<Student> students = IntStream.range(0, 1000).mapToObj(this::mapToStudent).collect(Collectors.toList());
        studentService.saveAll(students);
    }

    private void loadSubjects() {
        List<Subject> subjects = IntStream.range(0, 100).mapToObj(this::mapToSubject).collect(Collectors.toList());
        subjectService.saveAll(subjects);
    }


    private void loadAuthors() {
        List<Author> authors = IntStream.range(0, 500).mapToObj(this::mapToAuthors).collect(Collectors.toList());
        authorService.saveAll(authors);
    }


    private Author mapToAuthors(int i) {
        return new Author(String.format("Author %d", i));
    }

    private Student mapToStudent(int i) {
        return new Student(String.format("Student %d", i));
    }

    private Subject mapToSubject(int i) {
        return new Subject(String.format("Subject %d", i));
    }

    // __________________________________________________________________ //

    private void mapSubjectToStudent() {
        List<Student> students = studentService.findAllStudents();
        students = students.stream().map(this::mapSubject).collect(Collectors.toList());
        studentService.saveAll(students);
    }

    private Student mapSubject(Student student) {
        List<Long> subjectIds = new Random()
                .longs(20, 0, 100)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        List<Subject> subjectsList = subjectService.findByIdIn(subjectIds);
        student.setSubjects(subjectsList);
        return student;
    }

    // __________________________________________________________________ //

    private void mapSubjectToAuthor() {
        List<Author> authors = authorService.findAllAuthor();
        authors = authors.stream().map(this::mapAuthor).collect(Collectors.toList());
        authorService.saveAll(authors);
    }

    private Author mapAuthor(Author author) {
        List<Long> subjectIds = new Random()
                .longs(10, 0, 100)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        List<Subject> subjectsList = subjectService.findByIdIn(subjectIds);
        author.setSubjects(subjectsList);
        return author;
    }

    // ____________________________________________________________________  //

}
