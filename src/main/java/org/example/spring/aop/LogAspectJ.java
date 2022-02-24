package org.example.spring.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @Around("pj()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("1.around before invoke!!!");
//        MethodInvocation methodInvocation = ExposeInvocationInterceptor.currentInvocation();
//        Object[] arguments = methodInvocation.getArguments();
//        Method method = methodInvocation.getMethod();
//        Object invoke = method.invoke(methodInvocation.getThis(), arguments);
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("6.around after invoke!!!");
        return proceed;
    }
    @Before("pj()")
    public void logBefore(){
        MethodInvocation methodInvocation = ExposeInvocationInterceptor.currentInvocation();
        Object[] arguments = methodInvocation.getArguments();
        Method method = methodInvocation.getMethod();
        //method.invoke(methodInvocation.getThis(),arguments);
        System.out.println("2.before invoke!!!");
    }


    @After(value = "pj()")
    public void logAfter() {
        System.out.println("5.after invoke!!!");
    }

    @AfterReturning(value = "pj()",returning="o")
    public void logAfterReturning(Object o) {
        System.out.println("4.after invoke returning object is "+o+"!!!");
    }
}
