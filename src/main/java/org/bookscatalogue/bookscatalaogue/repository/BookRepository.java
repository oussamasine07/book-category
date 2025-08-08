package org.bookscatalogue.bookscatalaogue.repository;

import org.bookscatalogue.bookscatalaogue.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from books where title like %:keyword% or description like %:keyword%", nativeQuery = true)
    List<Book> searchBooksByTitleOrDescription(@Param("keyword") String keyword);

    @Query(value = "select count(*) from books", nativeQuery = true)
    Integer countBooks();


}
