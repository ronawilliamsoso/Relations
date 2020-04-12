package com.example.relations.twoEntitiesOneTable.model;

import com.example.relations.twoEntitiesOneTable.BaseMusic;
import lombok.Builder;
import lombok.Data;

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
public class Music extends BaseMusic{


    @Id
    @GeneratedValue
    private Long id;

    private String author;
}
