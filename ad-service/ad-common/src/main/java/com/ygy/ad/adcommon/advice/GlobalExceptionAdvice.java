package com.ygy.ad.adcommon.advice;

import com.ygy.ad.adcommon.exception.AdException;
import com.ygy.ad.adcommon.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest request, AdException ex){

        CommonResponse<String> response=new CommonResponse<>(-1,"business error");
        response.setData(ex.getMessage());
        return response;
    }
}
