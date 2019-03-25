package com.easycode.web.interceptors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserLoginInterceptor {
	
    @Value(value = "${message.topic.user.login}")
    private String topic;
    
	@Around("@annotation(userLogin)")
	 public Object afterUserLogin(final ProceedingJoinPoint pjp,UserLoginAnnotation userLogin) throws Throwable {
		
		 Object rs = pjp.proceed();

		 return rs;
	 }

}
