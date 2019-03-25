package com.easycode.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;

/**
 * @author yuqi
 * @date 19/3/25
 */
@Component
public class InitedEntity implements InitializingBean{

    int age = 0;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public InitedEntity(){
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

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessBeforeInitialization:"+beanName);
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

        System.out.println("postProcessAfterInitialization:"+beanName);
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

    @Override
    public String toString() {
        return "InitedEntity{" +
                "age=" + age +
                '}';
    }
}
