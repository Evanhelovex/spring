package org.example.spring.postprocessor;

import org.example.spring.tools.CustomizeTargetSourceCreator;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/22 11:12
 */
//AopBeanPostProcessor先于AnnotationAwareAspectJAutoProxyCreator实例化,
// AopBeanPostProcessor先于AnnotationAwareAspectJAutoProxyCreator实例化先加入BeanPostProcessor容器，AnnotationAwareAspectJAutoProxyCreator实例化才可以走postProcessBeforeInitialization方法
@Component
public class AopBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof AnnotationAwareAspectJAutoProxyCreator){
            AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator = (AnnotationAwareAspectJAutoProxyCreator) bean;
            annotationAwareAspectJAutoProxyCreator.setInterceptorNames("customizeAdvisor");
            /*CustomizeTargetSourceCreator customizeTargetSourceCreator = new CustomizeTargetSourceCreator();
            annotationAwareAspectJAutoProxyCreator.setCustomTargetSourceCreators(customizeTargetSourceCreator);*/
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
