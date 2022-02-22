package org.example.spring;

import org.example.spring.bean.B;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/9 2:29
 */
@ComponentScan(basePackages = "org.example.spring")
@EnableAspectJAutoProxy(exposeProxy = true)
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Test.class);
        B bean = annotationConfigApplicationContext.getBean(B.class);
        bean.test();
        System.out.println(bean);

    }
}
