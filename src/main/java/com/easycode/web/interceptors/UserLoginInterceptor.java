package com.easycode.web.interceptors;

import com.easycode.common.baseVO.BaseVO;
import com.easycode.common.baseVO.Code;
import com.easycode.message.model.UserMessage;
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
		 if(rs instanceof BaseVO){
			 BaseVO result = (BaseVO)rs;
			 if(Code.SUCCESS.text().equals(result.getCode())){
				 
				 UserMessage message = new UserMessage();
				 message.setUserId(2L);
				 message.setLoginTime(System.currentTimeMillis());
				 message.setUserName("小鱼儿");
			 }
		 }
		 
		 return rs;
	 }

}
