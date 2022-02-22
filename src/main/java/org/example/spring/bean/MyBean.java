package org.example.spring.bean;

import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/21 11:43
 */
public class MyBean {

    @PostConstruct
    private void init(){
        System.out.println("=====MyBean.init========");
    }
}
