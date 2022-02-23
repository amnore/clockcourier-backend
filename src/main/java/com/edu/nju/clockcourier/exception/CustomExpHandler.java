package com.edu.nju.clockcourier.exception;

import com.edu.nju.clockcourier.constant.ReturnMessage;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExpHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseVO<Object> customExceptionHandler(CustomException e) {
        return ResponseVO.failure().msg(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseVO<Object> exceptionHandler(Exception e) {
        return ResponseVO.failure().msg(ReturnMessage.UnknownExp.getMsg() + e.getMessage());
    }

}