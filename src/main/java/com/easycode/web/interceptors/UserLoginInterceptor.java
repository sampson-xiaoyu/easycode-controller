package com.easycode.web.interceptors;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.easycode.common.baseVO.BaseVO;
import com.easycode.common.baseVO.Code;
import com.easycode.message.kafka.template.ProducerTemplate;

@Aspect
@Component
public class UserLoginInterceptor {

    @Resource(name = "producerTemplate")
    private ProducerTemplate producerTemplate;

	@Around("@annotation(userLogin)")
	 public Object afterUserLogin(final ProceedingJoinPoint pjp,UserLoginAnnotation userLogin) throws Throwable {
		
		 Object rs = pjp.proceed();
		 if(rs instanceof BaseVO){
			 BaseVO result = (BaseVO)rs;
			 if(Code.SUCCESS.text().equals(result.getCode())){
				 producerTemplate.send("", "", "");
			 }
		 }
		 
		 return rs;
	 }

}
