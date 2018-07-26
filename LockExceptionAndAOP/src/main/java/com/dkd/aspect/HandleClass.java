package com.dkd.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect 
@Component  
public class HandleClass {
	
    @Pointcut(value = "@annotation(com.dkd.annotation.IsTryAgain)")  
    public void retry() throws Exception{
    	System.out.println("进来切面了……");
    } 
    
}
