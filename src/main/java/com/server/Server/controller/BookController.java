package com.server.Server.controller;

import com.server.Server.entity.BookEntity;
import com.server.Server.responce.BaseResponse;
import com.server.Server.responce.BookListResponse;
import com.server.Server.responce.BookResponse;
import com.server.Server.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<BookResponse> registration(@RequestBody BookEntity data) {
        try {
            BookEntity tempBook = service.save(data);
            return ResponseEntity.ok(new BookResponse(true, "Книга добавлена", tempBook));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(), null));
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
