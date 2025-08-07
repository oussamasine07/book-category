package org.bookscatalogue.bookscatalaogue.controller;


import jakarta.validation.Valid;
import org.bookscatalogue.bookscatalaogue.dto.validation.AuthorValidationDTO;
import org.bookscatalogue.bookscatalaogue.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController (
        final AuthorService authorService
    ) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthors () {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById (@PathVariable Long id) {
        return authorService.getAuthorById( id );
    }

    @PostMapping
    public ResponseEntity<?> createNewAuthor (@Valid @RequestBody AuthorValidationDTO authorValidationDTO) {
        return authorService.createAuthor(authorValidationDTO);
    }


}



















