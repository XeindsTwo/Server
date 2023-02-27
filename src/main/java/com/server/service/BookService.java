package com.server.service;

import com.server.entity.BookEntity;
import com.server.exception.ValidationException;
import com.server.repo.BookRepo;
import com.server.utils.ValidationBook;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public BookEntity save(BookEntity book) throws ValidationException {
        ValidationBook.validationBook(book);
        return repo.save(book);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Iterable<BookEntity> getAll(){
        return repo.findAll();
    }
}
