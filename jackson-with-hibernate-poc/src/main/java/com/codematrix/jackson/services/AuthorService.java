package com.codematrix.jackson.services;


import com.codematrix.jackson.entity.Author;
import com.codematrix.jackson.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(isolation = Isolation.READ_COMMITTED)
public class AuthorService {

    private AuthorRepository authorRepository;

    public List<Author> findAllAuthor() {
        return authorRepository.findAll();
    }

    public Optional<Author> findOneById(Long id) {
        return authorRepository.findById(id);
    }


    public void saveAll(List<Author> authors) {
        authorRepository.saveAll(authors);
    }


    public void save(Author author) {
        authorRepository.save(author);
    }

    public Author findOneWithSubject(Author author) {
        Author dbAuthor = authorRepository.findById(author.getId()).get();
        dbAuthor.getSubjects().size();
        return dbAuthor;
    }
}
