package com.server.controller;

import com.server.entity.AuthorEntity;
import com.server.responce.AuthorListResponse;
import com.server.responce.AuthorResponse;
import com.server.responce.BaseResponse;
import com.server.service.AuthorService;
import com.server.utils.ValidationAuthorUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new AuthorListResponse(service.getAll()));
    }
    @PostMapping("/add")
    public ResponseEntity<AuthorResponse> registrationAuthor(@RequestBody AuthorEntity data) {
        try {
            ValidationAuthorUtils.validationAuthor(data);
            AuthorEntity author = service.save(data);
            return ResponseEntity.ok(new AuthorResponse(true, "Автор добавлен", author));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthorResponse(false, e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Автор удалена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}
