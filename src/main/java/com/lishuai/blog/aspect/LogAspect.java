package com.lishuai.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author:shui.li
 * @Date:2019/1/1216:42
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //这里相当于让log代替了controller中的函数。
    @Pointcut("execution(* com.lishuai.blog.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
       //执行controller之前获取对应的信息
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();//获取请求

        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();
        //获取请求的方法和携带的参数
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        RequestLog requestLog=new RequestLog(url,ip,classMethod,args);
        logger.info("Request : {}",requestLog);
    }

//    @After("log()")
//    public void doAfter(){
//
//    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
           logger.info("Result : {}",result);
    }

    //内部类
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
