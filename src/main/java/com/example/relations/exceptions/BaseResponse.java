package com.example.relations.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
public class BaseResponse implements java.io.Serializable {

   Result result;


}