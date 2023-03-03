package com.server.utils;

import com.server.entity.PublishingEntity;
import com.server.exception.ValidationExceptionPublishing;

public class ValidationPublishingUtils {
    public static void validationPublishing(PublishingEntity data) throws ValidationExceptionPublishing {
        String publishingName = data.getPublishingName();
        if (publishingName == null || publishingName.isBlank() ||
                !publishingName.matches("[\\sA-ZА-Яa-zа-я0-9]{3,120}")) {
            throw new ValidationExceptionPublishing("Название имени издательства не должно быть пустым");
        }
        String city = data.getCity();
        if (city == null || city.isBlank() ||
                !city.matches("[\\sA-ZА-Яa-zа-я0-9]{3,120}")) {
            throw new ValidationExceptionPublishing("Издательство должно иметь адрес");
        }
    }
}
