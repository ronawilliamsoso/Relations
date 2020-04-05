package com.example.relations.repository;

import com.example.relations.ManyToOne.FilmComment;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Wei
 * @date 05.04.20
 */

@Repository
public interface FilmCommentRepository extends JpaRepository<FilmComment,Integer> {
}
