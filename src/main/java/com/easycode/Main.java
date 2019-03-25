package com.easycode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.easycode.web.consumer.UserMessageConsumer;

/**
 * @author yuqi
 * @date 19/3/25
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext(
                "classpath:spring/bean.xml");
        UserMessageConsumer a = (UserMessageConsumer) context.getBean("userMessageConsumer");
        System.out.println(a);

    }

}
