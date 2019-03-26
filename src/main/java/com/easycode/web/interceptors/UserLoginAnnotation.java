package com.easycode.web.interceptors;

import com.easycode.entity.AppConfig;
import com.easycode.entity.SpringEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1.该注解用于注解登录事件，然后进行拦截，然后根据不同的时间进行不同的操作
 * 2.目前用在LoginController的login上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Import(AppConfig.class)
@Component
public @interface UserLoginAnnotation {

}
