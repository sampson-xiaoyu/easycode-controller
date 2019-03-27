package com.easycode.entity;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

public class MyEventListener implements ApplicationListener<MyApplicationEvent> {

    public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
        System.out.println("接收事件"+myApplicationEvent.getSource() +":" + myApplicationEvent.getTimestamp());
    }
}
