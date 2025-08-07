package org.bookscatalogue.bookscatalaogue.repository;

import org.bookscatalogue.bookscatalaogue.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
