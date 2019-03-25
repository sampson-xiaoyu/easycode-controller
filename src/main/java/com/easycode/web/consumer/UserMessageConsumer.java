package com.easycode.web.consumer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class UserMessageConsumer implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("apostProcessBeforeInitialization:"+beanName);
        if(beanName.equals("initedEntity")){
            System.out.println("postProcessBeforeInitialization");
            try {
                Field filed = bean.getClass().getField("age");
                filed.set(bean, 1);
            }catch(Exception e){

            }
            System.out.println(bean);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("apostProcessAfterInitialization:"+beanName);
        if(beanName.equals("initedEntity")){

            System.out.println("postProcessAfterInitialization:");
            try {
                Field filed = bean.getClass().getField("age");
                filed.set(bean, 2);
            }catch(Exception e){

            }
            System.out.println(bean);
        }

        return bean;
    }

}
