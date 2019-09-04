package com.ygy.ad.adcommon.advice;

import com.ygy.ad.adcommon.annotation.IgnoreResponse;
import com.ygy.ad.adcommon.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一相应拦截
 */
@RestControllerAdvice
public class CommonResponseDateAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 相应是否支持拦截
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        if(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponse.class)){
            return false;
        }

        if(methodParameter.getMethod().isAnnotationPresent(IgnoreResponse.class)){
            return false;
        }

        return true;
    }

    /**
     * 写入响应前的操作
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        CommonResponse<Object> response=new CommonResponse<>(0,"");
        if(null == o){
            return response;
        }else if (o instanceof CommonResponse){
            response=(CommonResponse<Object>) o;
        }else {
            response.setData(o);
        }

        return response;
    }
}
