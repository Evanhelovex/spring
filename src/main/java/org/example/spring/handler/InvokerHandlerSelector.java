package org.example.spring.handler;

import cn.hutool.core.util.ClassUtil;
import org.example.spring.handler.InvokerHandler;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;


import java.util.List;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/19 13:16
 */
public class InvokerHandlerSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> beanNames = SpringFactoriesLoader.loadFactoryNames(InvokerHandler.class, ClassUtil.getClassLoader());
        return StringUtils.toStringArray(beanNames);
    }
}
