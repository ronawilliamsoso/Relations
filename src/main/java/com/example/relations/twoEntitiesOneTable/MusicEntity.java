package com.example.relations.twoEntitiesOneTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Wei
 * @date 12.04.20
 */


@Entity(name = "MusicEntity")
@Table(name = "music")
@Data
@Builder
public class MusicEntity extends BaseMusic<MusicEntity> {


    @Id
    @GeneratedValue
    private Long id;

    private String author;
}
