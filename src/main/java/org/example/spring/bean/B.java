package org.example.spring.bean;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/9 2:28
 */
@Component
public class B implements ApplicationContextAware {
    private ApplicationContext applicationContext;
//    private A a;
//
//    public B(A a) {
//        this.a = a;
//    }



    public String addUser(){
        System.out.println("3.local invoke!!!");
        return "local";
    }
    public void test(){
        B b = (B) AopContext.currentProxy();//ThreadLocal缓存代理对象
        B bean = applicationContext.getBean(B.class);//从spring容器拿代理对象
        b.addUser();
        //addUser();//不会走addUser增强
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
