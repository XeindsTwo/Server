package com.server.utils;

import com.server.entity.BookEntity;
import com.server.exception.ValidationExceptionAuthor;
import com.server.exception.ValidationExceptionBook;
import com.server.exception.ValidationExceptionPublishing;

public class ValidationBookUtils {
    public static void validationBook(BookEntity book)
            throws ValidationExceptionBook, ValidationExceptionAuthor, ValidationExceptionPublishing {
        String title = book.getTitle();
        if (title == null || title.isBlank()
                || !title.matches("[\\sA-ZА-Яa-zа-я0-9-.?!,:&]{3,120}")) {
            throw new ValidationExceptionBook("Неверно введено имя книги. " +
                    "Минимальное количество символов названия - 3, максимальное - 120");
        }
        if (book.getPublishing() == null) {
            throw new ValidationExceptionPublishing("Неверно введено имя издательства");
        }
        if (book.getAuthor() == null) {
            throw new ValidationExceptionAuthor("Неверно введено имя автора");
        }
        String kind = book.getTypeBook();
        if (kind == null || kind.isBlank()
                || !kind.matches("[\\sA-ZА-Яa-zа-я0-9-.?!,:&]{2,40}")) {
            throw new ValidationExceptionBook("Неверно введен жанр книги. " +
                    "Минимальное количество символов названия жанра книги - 2, максимальное - 40");
        }
        String year = String.valueOf(book.getYear());
        if (year.isBlank() || !year.matches("^\\d{3,4}")) {
            throw new ValidationExceptionBook("Неверно введен год издания книги. " +
                    "Попробуйте ввести снова год, начиная с 100 года");
        }
    }
}
