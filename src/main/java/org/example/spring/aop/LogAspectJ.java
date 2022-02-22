package org.example.spring.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/19 19:15
 */
@Aspect
@Component
public class LogAspectJ {

   /* @Around("execution(* *(..)) && @annotation(logAnnotation)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint,LogAnnotation logAnnotation) throws Throwable {
        System.out.println("打印开始日志==========");
        Object o = proceedingJoinPoint.proceed();
        System.out.println("打印结束日志==========");
        return o;
    }*/

    @Pointcut("execution(* org.example.spring.bean.*.addUser(..))")
    public void pj(){

    }

    @Before("pj()")
    public void logBefore() throws InvocationTargetException, IllegalAccessException {
        MethodInvocation methodInvocation = ExposeInvocationInterceptor.currentInvocation();
        Object[] arguments = methodInvocation.getArguments();
        Method method = methodInvocation.getMethod();
        //method.invoke(methodInvocation.getThis(),arguments);
        System.out.println("方法执行之前执行");
    }
}
