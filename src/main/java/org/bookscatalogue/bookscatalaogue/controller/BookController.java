package org.bookscatalogue.bookscatalaogue.controller;

import jakarta.validation.Valid;
import org.bookscatalogue.bookscatalaogue.dto.validation.BookValidationDTO;
import org.bookscatalogue.bookscatalaogue.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController (
            final BookService bookService
    ) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthors () {
        return bookService.getAllbookss();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById (@PathVariable Long id) {
        return bookService.getBookById( id );
    }

    @PostMapping
    public ResponseEntity<?> createNewAuthor (@Valid @RequestBody BookValidationDTO bookValidationDTO) {
        return bookService.createBook( bookValidationDTO );
    }





}
