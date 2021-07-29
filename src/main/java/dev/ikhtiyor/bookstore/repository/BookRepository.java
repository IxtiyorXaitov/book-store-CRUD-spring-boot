package dev.ikhtiyor.bookstore.repository;

import dev.ikhtiyor.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Ixtiyor
 * 29/07/21
 **/

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Integer id);
}
