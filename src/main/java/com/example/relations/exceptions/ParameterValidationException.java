package com.example.relations.exceptions;

/**
 * @author Wei
 * @date 12.04.20
 */

public class ParameterValidationException extends RuntimeException {


    private static final long serialVersionUID = -8436345056822409210L;

    public ParameterValidationException(ExceptionType exceptionType, String param) {

        super(exceptionType.name() + "#" + param);
    }

    public ParameterValidationException(ExceptionType exceptionType) {

        super(exceptionType.name());
    }

}

