package com.example.relations.twoEntitiesOneTable;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Wei
 * @date 12.04.20
 */

@Entity(name = "Music")
@Table(name = "music")
@Builder
public class Music extends BaseMusic{

    @Id
    @GeneratedValue
    private Long id;

    private String author;

}


