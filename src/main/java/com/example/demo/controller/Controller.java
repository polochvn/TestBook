package com.example.demo.controller;

import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.BookDto;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


/**
 * Controller
 *
 * @author Vladimir Polochanin
 */

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class Controller {
    private final AuthorService authorService;

    private final BookService bookService;

    @GetMapping("/{id}")
    ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(authorService.getById(id));
    }

    @PostMapping
    ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok(authorService.create(authorDto));
    }

    @PutMapping
    ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok(authorService.update(authorDto));
    }

    @DeleteMapping(value = "/{id}")
    void deleteAuthor(@PathVariable(name = "id") Long id) {
        authorService.delete(id);
    }

    @PostMapping("/{id}/book")
    ResponseEntity<BookDto> createBook(@PathVariable(name = "id") Long id,
                                       @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.create(id, bookDto));
    }

    @GetMapping("/{id}/book/{bookId}")
    ResponseEntity<BookDto> getBookById(@PathVariable(name = "id") Long id, @PathVariable(name = "bookId") Long bookId) {
        return ResponseEntity.ok(bookService.getById(id, bookId));
    }

    @PutMapping("/{id}/book")
    ResponseEntity<BookDto> updateBook(@PathVariable(name = "id") Long id,
                                       @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.update(bookDto));
    }

    @DeleteMapping(value = "/{id}/book/{bookId}")
    void deleteBook(@PathVariable(name = "id") Long id, @PathVariable(name = "bookId") Long bookId) {
        bookService.delete(bookId);
    }
}
