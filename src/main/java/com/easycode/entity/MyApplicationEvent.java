package com.easycode.entity;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {

    public MyApplicationEvent(String name) {
        super(name);
    }
}
