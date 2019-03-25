package com.easycode.web.consumer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class UserMessageConsumer implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessBeforeInitialization:"+beanName);
        if(beanName.equals("initedEntity")){
            try {

                Field field = ReflectionUtils.findField(bean.getClass(), "age");
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, bean, 1);

            }catch(Exception e){

            }
            System.out.println(bean);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessAfterInitialization:"+beanName);
        if(beanName.equals("initedEntity")){

            try {
                Field field = ReflectionUtils.findField(bean.getClass(), "age");
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, bean, 1);
            }catch(Exception e){
                System.out.println(bean);
            }
            System.out.println(bean);
        }

        return bean;
    }

}

