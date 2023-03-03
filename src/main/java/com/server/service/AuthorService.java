package com.server.service;

import com.server.entity.AuthorEntity;
import com.server.exception.ValidationExceptionAuthor;
import com.server.repo.AuthorRepo;
import com.server.utils.ValidationAuthorUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepo repo;

    public AuthorService(AuthorRepo repo) {
        this.repo = repo;
    }

    public AuthorEntity save(AuthorEntity author) {
        try {
            ValidationAuthorUtils.validationAuthor(author);
        } catch (ValidationExceptionAuthor e) {
            e.printStackTrace();
        }
        return repo.save(author);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Iterable<AuthorEntity> getAll() {
        return repo.findAll();
    }
}
