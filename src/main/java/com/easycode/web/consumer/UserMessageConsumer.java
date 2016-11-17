package com.easycode.web.consumer;

import java.util.List;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

import com.easycode.client.SearchClient;
import com.easycode.message.kafka.consumer.callbackListener.ConsumerCallbackListener;
import com.easycode.message.kafka.template.ConsumerTemplate;

public class UserMessageConsumer {
	    
    @Resource(name = "searchClient")
    private SearchClient searchClient;
	
    @Resource(name = "consumerTemplate")
    private ConsumerTemplate consumerTemplate;
    
    @Value(value = "${message.topic.user.login}")
    private String topic;
    @Value(value = "${message.group.user.login}")
    private String group;
    @Value(value = "${search.index}")
    private String index;
	
    @PostConstruct
    private void init(){
    	String [] topics = new String [] {topic};
    	consumerTemplate.startConsumerThread(topics, group, new UserConsumerCallbackListener());
    }
    
    class UserConsumerCallbackListener implements ConsumerCallbackListener{

		@Override
		public void afterReceive(List<Entry<String, String>> messages) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}
