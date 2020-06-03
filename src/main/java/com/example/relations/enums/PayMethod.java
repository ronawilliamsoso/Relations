package com.example.relations.enums;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * @author Wei
 * @date 26.05.20
 */


@NoArgsConstructor
public enum PayMethod {

    DD,CC,GP
}
