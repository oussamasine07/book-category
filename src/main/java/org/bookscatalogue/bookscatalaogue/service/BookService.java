package org.bookscatalogue.bookscatalaogue.service;


import org.bookscatalogue.bookscatalaogue.dto.validation.BookValidationDTO;
import org.bookscatalogue.bookscatalaogue.exception.NotFoundException;
import org.bookscatalogue.bookscatalaogue.model.Author;
import org.bookscatalogue.bookscatalaogue.model.Book;
import org.bookscatalogue.bookscatalaogue.repository.AuthorRepository;
import org.bookscatalogue.bookscatalaogue.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService (
            final BookRepository bookRepository,
            final AuthorRepository authorRepository
    ) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public ResponseEntity<?> getAllbookss () {
        List<Book> books = bookRepository.findAll();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    public ResponseEntity<?> getBookById (Long id) {
        Book book = bookRepository.findById( id )
                .orElseThrow(() -> new NotFoundException("book not found"));

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public ResponseEntity<?> createBook (BookValidationDTO bookValidationDTO) {
        Book book = new Book();

        book.setTitle( bookValidationDTO.title() );
        book.setIsbn( bookValidationDTO.isbn() );
        book.setDescription( bookValidationDTO.description() );

        Author author = authorRepository.findById( bookValidationDTO.author_id() )
                .orElseThrow(() -> new NotFoundException("author not found"));
        book.setAuthor( author );

        Book savedBook = bookRepository.save( book );
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    public ResponseEntity<?> searchByKeyword ( String keyword ) {
        List<Book> books = bookRepository.searchBooksByTitleOrDescription( keyword );

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    public ResponseEntity<?> countNumberOfBooks ( ) {
        Integer numBooks = bookRepository.countBooks();

        Map<String, Integer> result = new HashMap<>();
        result.put("number of books", numBooks);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
