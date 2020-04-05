package com.example.relations.onetoone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 * @author Wei
 * @date 04.04.20
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
public class BookDetail {

    @Id
    private Long id;//   @MapsId means bookDetail will share book's id，so no need "GeneratedValue" here

    private String bookAuthor;

    @OneToOne( fetch = FetchType.LAZY )
    @MapsId
    private Book book;

}
