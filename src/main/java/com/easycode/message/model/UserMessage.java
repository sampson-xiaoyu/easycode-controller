package com.easycode.message.model;

import com.easycode.message.kafka.message.Message;

public class UserMessage extends Message{
	
	Long userId;
	String userName;
	Long loginTime;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	
	
	
}
