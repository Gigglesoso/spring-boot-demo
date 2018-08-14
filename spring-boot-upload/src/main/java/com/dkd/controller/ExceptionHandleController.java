package com.dkd.controller;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * 用来处理全局的异常
 * @author Administrator
 */
@ControllerAdvice
@EnableWebMvc
public class ExceptionHandleController {
	
    @ExceptionHandler(Exception.class)
    public String handleError1(Exception e) {
        return "error";
    }
}
