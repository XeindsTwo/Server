package com.server.service;

import com.server.entity.PublishingEntity;
import com.server.exception.ValidationExceptionPublishing;
import com.server.repo.PublishingRepo;
import com.server.utils.ValidationPublishingUtils;
import org.springframework.stereotype.Service;

@Service
public class PublishingService {
    private final PublishingRepo repo;

    public PublishingService(PublishingRepo repo) {
        this.repo = repo;
    }

    public PublishingEntity save(PublishingEntity publishing) {
        try {
            ValidationPublishingUtils.validationPublishing(publishing);
        } catch (ValidationExceptionPublishing e) {
            e.printStackTrace();
        }
        return repo.save(publishing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Iterable<PublishingEntity> getAll() {
        return repo.findAll();
    }
}
