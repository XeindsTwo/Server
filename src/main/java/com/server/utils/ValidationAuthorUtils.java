package com.server.utils;

import com.server.entity.AuthorEntity;
import com.server.exception.ValidationExceptionAuthor;

public class ValidationAuthorUtils {
    public static void validationAuthor(AuthorEntity author) throws ValidationExceptionAuthor {
        String name = author.getName();
        if (name == null || name.isBlank() ||
                !name.matches("[\\sA-ZА-Яa-zа-я0-9-.?!,:&]{3,120}")) {
            throw new ValidationExceptionAuthor("Имя автора не соответствует требованиям. " +
                    "Минимальное количество символов - 3, Максимальное - 120");
        }
        String lastname = author.getLastname();
        if (lastname == null || lastname.isBlank() ||
                !lastname.matches("[\\sA-ZА-Яa-zа-я0-9-.?!,:&]{2,120}")) {
            throw new ValidationExceptionAuthor("Фамилия автора не соответствует требованиям. " +
                    "Минимальное количество символов - 2, Максимальное - 120");
        }
        String surname = author.getSurname();
        if (surname == null || surname.isBlank() ||
                !surname.matches("[\\sA-ZА-Яa-zа-я0-9-.?!,:&]{3,120}")) {
            throw new ValidationExceptionAuthor("Отчество автора не соответствует требованиям. " +
                    "Минимальное количество символов - 3, Максимальное - 120");
        }
    }
}
