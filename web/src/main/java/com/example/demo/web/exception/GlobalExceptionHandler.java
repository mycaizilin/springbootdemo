package com.example.demo.web.exception;

import com.example.demo.api.result.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/24 19:32
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public @ResponseBody
    Object handleCommonException(Exception ex, HttpServletRequest request) {
        System.out.println(ex);
        BaseResult baseResult=new BaseResult();
        baseResult.setSuccess(false);
        baseResult.setCode("error");
        baseResult.setMessage(ex.getMessage());
        return baseResult;
    }
}
