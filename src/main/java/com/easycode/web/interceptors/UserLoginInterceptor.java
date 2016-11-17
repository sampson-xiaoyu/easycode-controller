package com.easycode.web.interceptors;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.easycode.client.SearchClient;
import com.easycode.message.kafka.template.ProducerTemplate;


/**
 * lvhai
 * @author kongkonghu
 * 1.拦截到用户登录的动作
 */
@Aspect
@Component
public class UserLoginInterceptor {

    @Resource(name = "producerTemplate")
    private ProducerTemplate producerTemplate;
    
    @Resource(name = "searchClient")
    private SearchClient searchClient;
	
	@Around("@annotation(userLogin)")
	 public Object afterUserLogin(final ProceedingJoinPoint pjp,UserLoginAnnotation userLogin) throws Throwable {
		
		 Object rs = pjp.proceed();
		 
		 
		 return rs;
	 }

}
