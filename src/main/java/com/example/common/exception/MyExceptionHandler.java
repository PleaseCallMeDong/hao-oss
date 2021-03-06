package com.example.common.exception;

import com.example.common.base.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Objects;

/**
 * @author: dj
 * @create: 2020-03-05 09:18
 * @description: 异常处理器
 */
@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @Value("${spring.servlet.multipart.max-file-size}")
    private String fieMaxSize;

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(MyException.class)
    public MyResult handleMyException(MyException e) {
        return new MyResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public MyResult handleException(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            return MyResult.noPath();
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            return MyResult.error("请求类型错误");
        } else if (e instanceof MaxUploadSizeExceededException) {
            return MyResult.unauthorized("上传文件过大,请重新选择小于 " + fieMaxSize + " 文件上传");
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            return MyResult.error(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
        } else if (e instanceof BindException) {
            BindException exception = (BindException) e;
            return MyResult.error(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
        } else {
            log.error(e.getMessage(), e);
            return MyResult.error("未知异常,请联系管理员");
        }
    }

}
