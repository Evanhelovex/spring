package org.example.spring.tools;

import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;

/**
 * 对象未实例化前提前暴露代理对象
 * @author hetao
 * @version 1.0
 * @date 2022/2/23 14:15
 */
public class CustomizeTargetSource extends AbstractBeanFactoryBasedTargetSource {
    @Override
    public Object getTarget() throws Exception {
        return getBeanFactory().getBean(getTargetBeanName());
    }
}
