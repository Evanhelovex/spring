package org.example.spring.tools;

import org.example.spring.bean.A;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;


import java.io.IOException;

/**
 * 拿到对象的元信息
 * @author hetao
 * @version 1.0
 * @date 2022/2/19 12:36
 */
public class ResourceLoaderTest implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void test() throws IOException {
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);
        MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(A.class.getName());
        MergedAnnotations annotations = metadataReader.getAnnotationMetadata().getAnnotations();
    }
}
