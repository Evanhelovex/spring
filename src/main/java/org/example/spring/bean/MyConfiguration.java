package org.example.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/21 11:44
 */
@Configuration
public class MyConfiguration {

    @Bean(initMethod = "init")
    public MyBean myBean(){
        return new MyBean();
    }
}
