package org.bookscatalogue.bookscatalaogue.controller;


import org.bookscatalogue.bookscatalaogue.dto.validation.AuthorValidationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @GetMapping
    public ResponseEntity<?> getAllAuthors () {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById (Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> createNewAuthor (@RequestBody AuthorValidationDTO authorValidationDTO) {
        return null;
    }


}



















