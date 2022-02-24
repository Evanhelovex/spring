package org.example.spring.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


/**
 * 当C对象没有切面时
 * proxyMode=ScopedProxyMode.TARGET_CLASS时注入的时代理对象，方法实际调用时才会触发getBean
 * proxyMode=DEFAULT时，注入是对象本身
 * @author hetao
 * @version 1.0
 * @date 2022/2/23 15:14
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class C {

    public void getBeanCode(){
        System.out.println(this.hashCode());
    }
}
