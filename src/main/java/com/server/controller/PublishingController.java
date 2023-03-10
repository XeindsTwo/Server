package com.server.controller;

import com.server.entity.PublishingEntity;
import com.server.response.BaseResponse;
import com.server.response.PublishingListResponse;
import com.server.response.PublishingResponse;
import com.server.service.PublishingService;
import com.server.utils.ValidationPublishingUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/publishing")
public class PublishingController {
    private final PublishingService service;

    public PublishingController(PublishingService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new PublishingListResponse(service.getAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<PublishingResponse> registrationAuthor(@RequestBody PublishingEntity data) {
        try {
            ValidationPublishingUtils.validationPublishing(data);
            PublishingEntity publishing = service.save(data);
            return ResponseEntity.ok(new PublishingResponse(true, "Издательство добавлено", publishing));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new PublishingResponse(false, e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Издательство удалено"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}
