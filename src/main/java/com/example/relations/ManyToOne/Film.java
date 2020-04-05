package com.example.relations.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Film {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer  filmId;

    private String  filmName;
}
