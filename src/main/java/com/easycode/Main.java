package com.easycode;

import com.easycode.entity.SpringEntity;
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
        SpringEntity a = (SpringEntity) context.getBean("initedEntity");
        System.out.println(a);
        SpringEntity a1 = (SpringEntity) context.getBean("springEntity");
       System.out.println((a == a1)+":"+a+":"+a1);

    }

}
