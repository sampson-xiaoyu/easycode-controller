package com.easycode.pay.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import com.alipay.util.AlipayNotify;
import com.easycode.common.baseVO.BaseVO;
import com.easycode.common.baseVO.Code;
import com.easycode.pay.web.type.PayType;
import com.easycode.payManager.PayManager;
import com.wcpay.common.Signature;


@Controller
public class PayController {
	
	private PayManager payManager;
	
	@RequestMapping(value = "/toPay", method = RequestMethod.POST)
    @ResponseBody
	public BaseVO toPay(
	        @RequestParam(value = "paymentNum", required = true) String paymentNum,
            @RequestParam(value = "payType", required = false,defaultValue = "ALI_PAY") String payType,
            @RequestParam(value = "deviceInfo", required = false) String deviceInfo){
		BaseVO resultData= new BaseVO();
        /**
         * 支付宝支付
         */
        if(PayType.ALI_PAY.getCode().equals(payType)) {
            String aliPayStr= null;
            try {
                aliPayStr = payManager.toAliPay(paymentNum, "testAli", new BigDecimal("0.01"), new Date());
                resultData.setData(aliPayStr);
            } catch (UnsupportedEncodingException e) {
                throw new UnsupportedOperationException("签名验证失败");
            }
            return resultData;
        }
        /**
         * 微信支付
         */
        if(PayType.WCHAT_PAY.getCode().equals(payType)){
            Map<String,Object> wchatPayData= null;
            try {
                wchatPayData = payManager.toWChatPay("testWChat", paymentNum, 1, "", deviceInfo, new Date());
            } catch (Exception e) {
                throw new UnsupportedOperationException("签名验证失败");
            }
            resultData.setData(wchatPayData);
            return resultData;
        }
        /**
         * 支付方式验证失败
         */
        resultData.setMsg("支付方式有误");
        resultData.setCode(Code.FAIL.name());
        return resultData;

    }
	
	@RequestMapping(value = "/alipay/notify", method = RequestMethod.POST)
	public void notify(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		PrintWriter out = response.getWriter();
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}

		String resp = "fail";

		String trade_status = params.get("trade_status");
		if (AlipayNotify.verify(params)) {
			if (trade_status.equals("TRADE_FINISHED")) {
				System.out.println("TRADE_FINISHED"+params.toString());
			} else if (trade_status.equals("TRADE_SUCCESS")) {
				System.out.println("TRADE_SUCCESS"+params.toString());
			}
		}
		out.println(resp);
		out.flush();
		out.close();
	}
	/**
     * app付款异步通知处理接口
     * @param request
     * @param response
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    @RequestMapping(value = "/wchatpay/notify", method = RequestMethod.POST)
    @ResponseBody
    public void wchatReturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean flag=false;
        PrintWriter out = response.getWriter();
        String context= getRequestBody(request);
        /**
         * 验证数据是否被修改
         */
        try {
            if(Signature.checkIsSignValidFromResponseString(context)){
            	 flag = true;
            }
        }catch (Exception e){
            flag=false;
        }
        if(flag){
            out.println("SUCCESS:"+context);
            out.flush();
            out.close();
        }else{
            out.println("FAIL:"+context);
            out.flush();
            out.close();
        }
    }
    /**
     * 获得request对象的信息
     * @param request
     * @return
     * @throws IOException
     */
    private String getRequestBody(HttpServletRequest request) throws IOException {
        byte[] buffer = new byte[64*1024];
        InputStream in = request.getInputStream();
        int length = in.read(buffer);
        String encode = request.getCharacterEncoding();
        byte[] data = new byte[length];
        System.arraycopy(buffer, 0, data, 0, length);
        String context = new String(data, encode);
        return context;
    }
}
