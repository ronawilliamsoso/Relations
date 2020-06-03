package com.example.relations.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handle(Exception exception) {
        logger.error(exception.getMessage(), exception);
        return buildBaseResponse(
                "Unexpected exception appeared: " + exception.getMessage(),
                ErrorCode.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse handle(MethodArgumentTypeMismatchException exception) {
        logger.error(exception.getMessage(), exception);
        return buildBaseResponse(
                exception.getMessage(),
                ErrorCode.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value()
        );
    }



    @ExceptionHandler( value = ParameterValidationException.class )
    @ResponseBody
    @ResponseStatus( HttpStatus.BAD_REQUEST )
    public static BaseResponse handle(ParameterValidationException exception) {
        GlobalExceptionHandler.logger.error(exception.getMessage(), exception);
        String[] codeAndData = exception.getMessage().split("#");
        ExceptionType exceptionType = ExceptionType.valueOf(codeAndData[0]);
        if ( codeAndData.length == 2 ) {
            return GlobalExceptionHandler.buildBaseResponse(codeAndData[1], exceptionType, HttpStatus.BAD_REQUEST.value());
        }else {
            return GlobalExceptionHandler.buildBaseResponse(exceptionType, HttpStatus.BAD_REQUEST.value());
        }
    }




    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse handle(IllegalArgumentException exception) {
        logger.error(exception.getMessage(), exception);
        return buildBaseResponse(
                "IllegalArgumentException exception appeared: " + exception.getMessage(),
                ErrorCode.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value()
        );
    }



    private BaseResponse buildBaseResponse(String message, ErrorCode errorCode, int httpStatus) {
        BaseResponse baseResponse = new BaseResponse();
        Result result = new Result();
        result.setErrorCode(errorCode.getCode());
        result.setErrorMessage(message);
        result.setReturnCode(httpStatus);
        result.setSuccess(Boolean.FALSE);
        baseResponse.setResult(result);

        return baseResponse;
    }

    private static BaseResponse buildBaseResponse(String paramData, ExceptionType exceptionType, int httpStatus) {
        BaseResponse baseResponse = new BaseResponse();
        Result result = new Result();
        result.setErrorCode(exceptionType.getErrorCode());
        result.setErrorMessage(exceptionType.getErrorMessage() + ": " + paramData);
        result.setReturnCode(httpStatus);
        result.setSuccess(Boolean.FALSE);
        baseResponse.setResult(result);
        return baseResponse;
    }

    private static BaseResponse buildBaseResponse(String paramData, String paramType, ExceptionType exceptionType, int httpStatus) {
        BaseResponse baseResponse = new BaseResponse();
        Result result = new Result();
        result.setErrorCode(exceptionType.getErrorCode());
        result.setErrorMessage(exceptionType.getErrorMessage() + ": " + paramData +"(" +paramType+ ")");
        result.setReturnCode(httpStatus);
        result.setSuccess(Boolean.FALSE);
        baseResponse.setResult(result);
        return baseResponse;
    }

    private static BaseResponse buildBaseResponse(ExceptionType exceptionType, int httpStatus) {
        BaseResponse baseResponse = new BaseResponse();
        Result result = new Result();
        result.setErrorCode(exceptionType.getErrorCode());
        result.setErrorMessage(exceptionType.getErrorMessage());
        result.setReturnCode(httpStatus);
        result.setSuccess(Boolean.FALSE);
        baseResponse.setResult(result);
        return baseResponse;
    }
}
