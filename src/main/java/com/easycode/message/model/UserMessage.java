package com.easycode.message.model;

import com.easycode.message.kafka.message.Message;

public class UserMessage extends Message{
	
	Long userId;
	Long userName;
	Long loginTime;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUserName() {
		return userName;
	}
	public void setUserName(Long userName) {
		this.userName = userName;
	}
	public Long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	
	
	
}
