package org.example.spring.bean;

import org.example.spring.handler.InvokerHandler;
import org.example.spring.handler.InvokerHandlerSelector;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/9 2:28
 */
@Component
@Import(value = InvokerHandlerSelector.class)
public class A implements InitializingBean {


    private String factoryName;

    @Autowired
    private C c;

    @Autowired
    @Qualifier("b")
    private B b;

//    public A(C c, B b) {
//        this.c = c;
//        this.b = b;
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(factoryName);
    }

    public void addUser(String str){
        System.out.println(str);
    }

    public void testPrototype(){
        System.out.println(c);
        c.getBeanCode();
    }
}
