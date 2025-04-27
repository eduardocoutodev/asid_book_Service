package com.ijse.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ijse.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b FROM Book b " +
            "LEFT JOIN b.author a " +          // Explicit LEFT JOIN
            "LEFT JOIN b.category c " +        // Explicit LEFT JOIN
            "LEFT JOIN b.subcategory sc " +    // Explicit LEFT JOIN
            "WHERE (:query IS NULL OR " +
            "LOWER(b.title) LIKE LOWER(concat('%', :query, '%')) OR " +
            "LOWER(a.authorName) LIKE LOWER(concat('%', :query, '%')) OR " + // Check joined author name
            "LOWER(c.name) LIKE LOWER(concat('%', :query, '%')) OR " +       // Check joined category name
            "LOWER(sc.name) LIKE LOWER(concat('%', :query, '%')))")
    List<Book> searchBooks(@Param("query") String query);


    List<Book> findByCategoryId(Long id);

    

}
