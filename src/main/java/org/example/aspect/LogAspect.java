package org.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    
    @Pointcut("execution(* org.example.API.LogAPI.log(..))")
    public void log(){}
    
    @Before("log()")
    public void doBefore() {
        System.out.println("Before Test!!");
    }
    
    @After("log()")
    public void doAfter() {
        System.out.println("After Test!!");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result){
        System.out.println(result);
    }
    //以上的打印順序 B>log>return>A

}
