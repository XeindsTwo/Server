package com.server.repo;

import com.server.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<AuthorEntity, Long> {
}
