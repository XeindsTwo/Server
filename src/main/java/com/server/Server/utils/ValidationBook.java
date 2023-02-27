package com.server.Server.utils;

import com.server.Server.entity.BookEntity;
import com.server.Server.exception.ValidationException;

public class ValidationBook {
    public static void validationBook(BookEntity book) throws ValidationException {
        String bookStringTitle = book.getTitle();
        if (bookStringTitle == null || bookStringTitle.isBlank()
                || !bookStringTitle.matches("[\\sA-ZА-Яa-zа-я0-9]{3,120}")) {
            throw new ValidationException("Неверно введено имя книги. " +
                    "Минимальное количество символов названия - 3, максимальное - 120");
        }
        String bookStringAuthor = book.getAuthor();
        if (bookStringAuthor == null || bookStringAuthor.isBlank()
                || !bookStringAuthor.matches("[\\sA-ZА-Яa-zа-я0-9]{2,120}")) {
            throw new ValidationException("Неверно введено имя автора. " +
                    "Минимальное количество символов имени - 2, максимальное - 120");
        }
        String bookStringPublishing = book.getPublishing();
        if (bookStringPublishing == null || bookStringPublishing.isBlank()
                || !bookStringPublishing.matches("[\\sA-ZА-Яa-zа-я0-9]{3,70}")) {
            throw new ValidationException("Неверно введено название издательства. " +
                    "Минимальное количество символов названия издательства - 3, максимальное - 70");
        }
        String bookStringKind = book.getTypeBook();
        if (bookStringKind == null || bookStringKind.isBlank()
                || !bookStringKind.matches("[\\sA-ZА-Яa-zа-я0-9]{2,40}")) {
            throw new ValidationException("Неверно введен жанр книги. " +
                    "Минимальное количество символов названия жанра книги - 2, максимальное - 40");
        }
        String bookIntYear = String.valueOf(book.getYear());
        if (bookIntYear.isBlank() || !bookIntYear.matches("^\\d{3,4}")) {
            throw new ValidationException("Неверно введен год издания книги. " +
                    "Попробуйте ввести снова год, начиная с 100 года");
        }
    }
}
