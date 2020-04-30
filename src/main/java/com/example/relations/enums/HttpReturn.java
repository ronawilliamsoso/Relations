package com.example.relations.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author Wei
 * @date 16.04.20
 */

@Getter
public enum HttpReturn {
    SUCCESS(200, "Success"), BAD_REQUEST(300, "Bad request"), NOT_FOUND(404, "Not found"), INTERNAL_SERVER_ERROR(500, "Service Error");

    HttpReturn(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private final Integer code;
    private final String message;

}