package com.easycode.web.interceptors;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.easycode.common.baseVO.BaseVO;
import com.easycode.common.baseVO.Code;
import com.easycode.message.kafka.message.manager.MessageManager;
import com.easycode.message.model.UserMessage;

@Aspect
@Component
public class UserLoginInterceptor {
	
    @Resource(name = "messageManager")
    private MessageManager messageManager;
    @Value(value = "${message.topic.user.login}")
    private String topic;
    
	@Around("@annotation(userLogin)")
	 public Object afterUserLogin(final ProceedingJoinPoint pjp,UserLoginAnnotation userLogin) throws Throwable {
		
		 Object rs = pjp.proceed();
		 if(rs instanceof BaseVO){
			 BaseVO result = (BaseVO)rs;
			 if(Code.SUCCESS.text().equals(result.getCode())){
				 
				 UserMessage message = new UserMessage();
				 message.setUserId(2L);
				 message.setLoginTime(System.currentTimeMillis());
				 message.setUserName("小鱼儿");
				 messageManager.sendUserMessage(topic, message);
			 }
		 }
		 
		 return rs;
	 }

}
