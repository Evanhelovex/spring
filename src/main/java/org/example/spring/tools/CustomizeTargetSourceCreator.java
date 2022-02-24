package org.example.spring.tools;

import org.example.spring.bean.A;
import org.example.spring.tools.CustomizeTargetSource;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.TargetSourceCreator;
import org.springframework.aop.framework.autoproxy.target.AbstractBeanFactoryBasedTargetSourceCreator;
import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/23 14:19
 */
public class CustomizeTargetSourceCreator extends AbstractBeanFactoryBasedTargetSourceCreator {

    @Override
    protected AbstractBeanFactoryBasedTargetSource createBeanFactoryBasedTargetSource(Class<?> beanClass, String beanName) {
        if(beanClass.isAssignableFrom(A.class)){
            CustomizeTargetSource customizeTargetSource = new CustomizeTargetSource();
            return customizeTargetSource;
        }
        return null;
    }
}
