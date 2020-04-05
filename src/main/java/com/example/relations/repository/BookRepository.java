package com.example.relations.repository;

import com.example.relations.onetoone.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wei
 * @date 04.04.20
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
