package com.server.controller;

import com.server.entity.BookEntity;
import com.server.responce.BaseResponse;
import com.server.responce.BookListResponse;
import com.server.service.BookService;
import com.server.utils.ValidationBookUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }

    @GetMapping("/")
    public ResponseEntity<BaseResponse> getPublisher(@RequestParam String name, @RequestParam String city) {
        return ResponseEntity.ok(new BookListResponse(service.getPublishing(name, city)));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> registration(@RequestBody BookEntity data) {
        try {
            ValidationBookUtils.validationBook(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Книга добавлена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Информация о книге была обновлена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<BaseResponse> upData(@RequestBody BookEntity book, @PathVariable Long id) {
        try {
            service.save(book);
            return ResponseEntity.ok(new BaseResponse(true, "Поле было изменено"));
        } catch (Exception e) {
            return ResponseEntity.ok(new BaseResponse(false, "Невозможно изменить поле"));
        }
    }
}
