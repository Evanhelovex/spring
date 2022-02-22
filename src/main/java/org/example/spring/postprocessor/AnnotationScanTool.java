package org.example.spring.postprocessor;

import cn.hutool.core.collection.CollectionUtil;
import lombok.SneakyThrows;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;

/**
 * @author hetao
 * @version 1.0
 * @date 2022/2/14 11:06
 */

//@Component
public class AnnotationScanTool implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
    /*@Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        List<String> contentList = new ArrayList<>();
        if(Objects.nonNull(bean)&&Objects.nonNull(beanName)){
            Class<?> beanClass = bean.getClass();
            Service annotation = beanClass.getAnnotation(Service.class);
            if(Objects.nonNull(annotation)){
                String value = annotation.value();
                if(Objects.nonNull(value)){
                    contentList.add(value);
                }
            }
        }
        if(CollectionUtil.isNotEmpty(contentList)){
            String content = listToString(contentList,"\r\n");
            writeScanResult(content);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean,beanName);
    }*/


    @SneakyThrows
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
       /* ClassPathScanningCandidateComponentProvider pathScanningCandidateComponentProvider = new ClassPathScanningCandidateComponentProvider(false);
        pathScanningCandidateComponentProvider.addIncludeFilter(new AnnotationTypeFilter(Service.class));
        Set<BeanDefinition> candidateComponents = pathScanningCandidateComponentProvider.findCandidateComponents("");
        List<String> contentList = new ArrayList<>();
        for (BeanDefinition beanDefinition : candidateComponents) {
            ScannedGenericBeanDefinition scannedGenericBeanDefinition = (ScannedGenericBeanDefinition) beanDefinition;
            AnnotationMetadata metadata = scannedGenericBeanDefinition.getMetadata();
            MergedAnnotations annotations = metadata.getAnnotations();
            MergedAnnotation<Service> tableNameMergedAnnotation = annotations.get(Service.class);
            String value = tableNameMergedAnnotation.getString("value");
            if(Objects.nonNull(value)){
                contentList.add(value);
            }
        }
        if(!CollectionUtils.isEmpty(contentList)){
            String content = listToString(contentList,"\r\n");
            writeScanResult(content);
        }
*/
    }

    public String listToString(List<String> list, String separator) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            if (s != null && !"".equals(s)) {
                sb.append(separator).append(s);
            }
        }
        return sb.toString();
    }

    public void writeScanResult(String content){
        File file = new File("D:\\scan\\result.txt");
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8"));
            writer.write(content);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(writer != null){}
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AnnotationAwareAspectJAutoProxyCreator bean = (AnnotationAwareAspectJAutoProxyCreator) beanFactory.getBean(AopConfigUtils.AUTO_PROXY_CREATOR_BEAN_NAME);
        bean.setInterceptorNames("customizeAdvisor");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
