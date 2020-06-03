package com.example.relations.compositeKey;

import com.example.relations.enums.PayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Wei
 * @date 04.04.20
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class DrawPeriodCutOff {

    @EmbeddedId
    CutOffPk cutOffPk;

    @Column(insertable = false, updatable = false )
    private PayMethod payMethod;

    private Date cutOff;

}
