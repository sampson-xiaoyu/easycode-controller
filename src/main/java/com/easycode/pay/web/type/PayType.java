package com.easycode.pay.web.type;

public enum PayType {

	ALI_PAY("ALI_PAY","支付宝支付"), WCHAT_PAY("WCHAT_PAY","微信支付");

	private PayType(String code,String name) {
		this.code = code;
        this.name = name;
	}
	

	public static PayType getPayType(byte code){
		for (PayType o : PayType.values()) {
			if(o.code.equals(code)){
				return o;
			}
		}
		return null;
	}

	private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
