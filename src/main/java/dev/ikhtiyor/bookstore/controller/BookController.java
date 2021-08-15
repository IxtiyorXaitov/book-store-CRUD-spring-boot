package dev.ikhtiyor.bookstore.controller;

import dev.ikhtiyor.bookstore.payload.ApiResponse;
import dev.ikhtiyor.bookstore.payload.BookDto;
import dev.ikhtiyor.bookstore.service.BookService;
import dev.ikhtiyor.bookstore.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created By Ixtiyor
 * 29/07/21
 **/

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/book")
public class BookController {

    final
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public HttpEntity<?> create(
            @Valid @RequestBody BookDto request
    ) {
        ApiResponse apiResponse = bookService.create(request);

        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/get/{id}")
    public HttpEntity<?> getOne(
            @PathVariable(name = "id") Integer id
    ) {
        ApiResponse apiResponse = bookService.getOne(id);

        return ResponseEntity.ok(apiResponse);

    }

    @GetMapping("/get/all")
    public HttpEntity<?> getAll(
            @RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE) Integer page,
            @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_SIZE) Integer size
    ) {
        ApiResponse apiResponse = bookService.getAll(page, size);

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/update/{id}")
    public HttpEntity<?> update(
            @PathVariable(name = "id") Integer id,
            @Valid @RequestBody BookDto request
    ) {
        ApiResponse apiResponse = bookService.update(id, request);

        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);

    }


    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(
            @PathVariable(name = "id") Integer id
    ) {
        ApiResponse apiResponse = bookService.delete(id);

        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

}
