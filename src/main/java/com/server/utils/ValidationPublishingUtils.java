package com.server.utils;

import com.server.entity.PublishingEntity;
import com.server.exception.ValidationExceptionPublishing;

public class ValidationPublishingUtils {
    public static void validationPublishing(PublishingEntity data) throws ValidationExceptionPublishing {
        String name = data.getName();
        if (name == null || name.isBlank() ||
                !name.matches("[\\sA-ZА-Яa-zа-я0-9-.?!,:&]{3,120}")) {
            throw new ValidationExceptionPublishing("Неверно введено название издательства, попробуйте снова. " +
                    "Минимальное количество символов - 3, максимальное - 120");
        }
        String city = data.getCity();
        if (city == null || city.isBlank() ||
                !city.matches("[\\sA-ZА-Яa-zа-я0-9-.?!,:&]{3,120}")) {
            throw new ValidationExceptionPublishing("Неверно введено адрес издательства, попробуйте снова. " +
                    "Минимальное количество символов - 3, максимальное - 120");
        }
    }
}
