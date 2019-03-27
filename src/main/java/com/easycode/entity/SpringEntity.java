package com.easycode.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author yuqi
 * @date 19/3/25
 */
public class SpringEntity implements InitializingBean, BeanFactoryAware,
        BeanClassLoaderAware, BeanNameAware, ApplicationContextAware, ImportAware, ApplicationEventPublisherAware,
        ImportBeanDefinitionRegistrar, ImportSelector{

    String age;

    public SpringEntity(){
        System.out.println("InitedEntity generate");
    }


    public void initMethod(){
        System.out.println("initMethod");
    }

    public void afterPropertiesSet() throws Exception {

        System.out.println("initializingBean");
    }

    @PostConstruct
    public void init(){

        System.out.println("PostConstruct");
    }

    @Override
    public String toString() {
        return "InitedEntity{" +
                "age=" + age +
                '}';
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader"+classLoader.getClass()+":"+classLoader.getParent().getClass());
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory:"+beanFactory);
    }

    public void setBeanName(String s) {
        System.out.println(s);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext,applicationContext:"+applicationContext);
    }

    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        System.out.println("setImportMetadata,annotationMetadata:"+annotationMetadata);
    }

    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        System.out.println("registerBeanDefinitions,annotationMetadata:"+annotationMetadata+"beanDefinitionRegistry:"+beanDefinitionRegistry);
    }

    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        System.out.println("selectImports:annotationMetadata:"+annotationMetadata);
        return new String[0];
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("发布事件"+applicationEventPublisher);
        applicationEventPublisher.publishEvent(new MyApplicationEvent("你好"));
    }
}
