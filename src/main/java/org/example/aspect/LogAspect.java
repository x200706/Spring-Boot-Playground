package org.example.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import lombok.Data;

@Component
@Aspect
public class LogAspect {
    
    @Pointcut("execution(* org.example.API.LogAPI.log(..))")
    public void log(){}
    
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("Before Test!!");

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        ReqLog reqLog = new ReqLog(request.getRequestURL().toString(), request.getRemoteAddr(),method,joinPoint.getArgs());

        System.out.println(reqLog);
    }
    
    @After("log()")
    public void doAfter() {
        System.out.println("After Test!!");
    }

    @AfterReturning(returning = "result", pointcut = "log()") //換言之可以做統一紀錄
    public void doAfterReturning(Object result){
        System.out.println(result);
    }
    //以上的打印順序 B>log>return>A

    @Data
    private class ReqLog{
        public ReqLog(String url, String ip, String method, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.method = method;
            this.args = args;
        }
        private String url;
        private String ip;
        private String method;
        private Object[] args;
    }

}
