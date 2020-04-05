package com.example.relations.repository;

import com.example.relations.onetoone.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wei
 * @date 04.04.20
 */

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {
}
