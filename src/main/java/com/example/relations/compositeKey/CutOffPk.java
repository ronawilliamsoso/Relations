package com.example.relations.compositeKey;

import com.example.relations.enums.PayMethod;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * @author Wei
 * @date 26.05.20
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CutOffPk implements Serializable {

    private Integer drawPeriodNumber;

    @Enumerated( EnumType.STRING)
    private PayMethod payMethod;
}
