package com.easycode.common.baseVO;

public enum Code {
	
	SUCCESS("success"),FAIL("fail");
	
	private String code;
	
	private Code(String code){
		this.code = code;
	}
	
	public String text(){
		return this.code;
	}
}
