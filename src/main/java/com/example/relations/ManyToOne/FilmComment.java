package com.example.relations.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Author wangwei
 * @Date 07.03.20
 **/

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmComment {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer  commentId;

    private String  commentText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", referencedColumnName = "filmId")//
    //referencedColumnName here can be deleted, because parentId is its default value.
    // referencedColumnName is needed when the foreign key is not the primary key of the parent
    private Film film;

}
