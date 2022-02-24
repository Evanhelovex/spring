package org.example.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/22 10:52
 */
@Component
public class CustomizeAdvisor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //System.out.println("----customize----");
        return invocation.proceed();
    }
}
