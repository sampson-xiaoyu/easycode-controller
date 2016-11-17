package com.easycode.web.consumer;

import javax.annotation.Resource;

import com.easycode.client.SearchClient;
import com.easycode.message.kafka.template.ConsumerTemplate;

public class UserMessageConsumer {
	
    
    @Resource(name = "searchClient")
    private SearchClient searchClient;
	
    @Resource(name = "consumerTemplate")
    private ConsumerTemplate consumerTemplate;
	
}
