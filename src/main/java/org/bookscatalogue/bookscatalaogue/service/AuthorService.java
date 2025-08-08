package org.bookscatalogue.bookscatalaogue.service;

import org.bookscatalogue.bookscatalaogue.dto.validation.AuthorValidationDTO;
import org.bookscatalogue.bookscatalaogue.exception.NotFoundException;
import org.bookscatalogue.bookscatalaogue.model.Author;
import org.bookscatalogue.bookscatalaogue.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService (
            final AuthorRepository authorRepository
    ) {
        this.authorRepository = authorRepository;
    }

    public ResponseEntity<?> getAllAuthors () {
        List<Author> authors = authorRepository.findAll();

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    public ResponseEntity<?> getAuthorById (Long id) {
        Author author = authorRepository.findById( id )
                .orElseThrow(() -> new NotFoundException("author not found"));

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    public ResponseEntity<?> createAuthor (AuthorValidationDTO authorValidationDTO) {
        Author author = new Author();

        author.setName( authorValidationDTO.name() );
        author.setBiography( authorValidationDTO.biography() );

        Author savedAuthor = authorRepository.save( author );
        return new ResponseEntity<>(savedAuthor, HttpStatus.OK);
    }

    public ResponseEntity<?> findAuthorNameStartsWith (char letter ) {
        List<Author> authors = authorRepository.findAuthorNameStartedWith( letter );

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

}































