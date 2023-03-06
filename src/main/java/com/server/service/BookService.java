package com.server.service;

import com.server.entity.BookEntity;
import com.server.exception.ValidationExceptionAuthor;
import com.server.exception.ValidationExceptionBook;
import com.server.exception.ValidationExceptionPublishing;
import com.server.repo.BookRepo;
import com.server.utils.ValidationBookUtils;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public BookEntity save(BookEntity book) {
        try {
            ValidationBookUtils.validationBook(book);
        } catch (ValidationExceptionPublishing | ValidationExceptionBook | ValidationExceptionAuthor e) {
            e.printStackTrace();
        }
        return repo.save(book);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Iterable<BookEntity> getAll() {
        return repo.findAll();
    }

    public Iterable<BookEntity> getPublishing(String name, String city) {
        return repo.findDistinctByPublishing_NameOrPublishingCity(name, city);
    }
}
