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


@Entity(name = "MusicCd")
@Table(name = "music_cd")
@Data
@Builder
public class MusicCd extends BaseMusic {


    @Id
    @GeneratedValue
    private Long id;// this id will share the same sequence with other two siblings.

    private String author;
}
