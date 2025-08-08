package org.bookscatalogue.bookscatalaogue.repository;

import org.bookscatalogue.bookscatalaogue.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "select * from authors where name like :letter%", nativeQuery = true )
    List<Author> findAuthorNameStartedWith(@Param("letter") char letter);

}
