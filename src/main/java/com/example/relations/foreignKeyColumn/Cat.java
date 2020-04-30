package com.example.relations.foreignKeyColumn;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author Wei
 * @date 30.04.20
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@JsonInclude( JsonInclude.Include.NON_NULL )
public class Cat implements Serializable {
    @Id
    private Integer masterId;// the same as fkey will have less queries

    private String catName;

    private String catGender;

    @OneToOne( fetch = FetchType.LAZY )
    @MapsId
    @JoinColumn(name = "master_id")
    private Master master;
}
