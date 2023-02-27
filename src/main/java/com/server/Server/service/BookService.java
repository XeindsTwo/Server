package com.server.Server.service;

import com.server.Server.entity.BookEntity;
import com.server.Server.exception.ValidationException;
import com.server.Server.repo.BookRepo;
import com.server.Server.utils.ValidationBook;
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
