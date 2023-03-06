package com.server.repo;

import com.server.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
    Iterable<BookEntity> findDistinctByPublishing_NameOrPublishingCity(String title, String city);
}
