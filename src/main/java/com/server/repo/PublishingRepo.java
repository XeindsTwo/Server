package com.server.repo;

import com.server.entity.PublishingEntity;
import org.springframework.data.repository.CrudRepository;

public interface PublishingRepo extends CrudRepository<PublishingEntity, Long> {
}
