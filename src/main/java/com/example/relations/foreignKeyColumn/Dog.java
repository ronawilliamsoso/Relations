package com.example.relations.foreignKeyColumn;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Dog implements Serializable {
    @Id
    @Column(name="master_id", unique=true, nullable=false, precision=11)
    private Integer masterId;

    private String dogName;

    private String dogGender;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="master_id", referencedColumnName="master_id", updatable=false, insertable=false)
    private Master master;
}
