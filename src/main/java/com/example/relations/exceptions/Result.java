package com.example.relations.exceptions;

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
 * @date 01.05.20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result implements java.io.Serializable {

    private java.lang.Boolean success;

    private java.lang.Integer returnCode;

    private java.lang.String errorCode;

    private java.lang.String errorMessage;


}