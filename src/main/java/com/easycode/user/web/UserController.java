package com.easycode.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.easycode.common.baseVO.BaseVO;
import com.easycode.web.interceptors.UserLoginAnnotation;

@Controller
public class UserController {
	
	@UserLoginAnnotation
	@RequestMapping(value="/login" , method = {RequestMethod.POST , RequestMethod.GET})
	public BaseVO userLogin(@RequestParam(value="username",required = true) String userName,
			@RequestParam(value = "password",required = true) String password){
		
		if("xiaoyu".equals(userName) && "123456".equals(password)){
			
		}
		
		return new BaseVO();
	}
}