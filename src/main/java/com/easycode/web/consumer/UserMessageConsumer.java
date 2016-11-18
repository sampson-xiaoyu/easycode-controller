package com.easycode.web.consumer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.easycode.client.SearchClient;
import com.easycode.commons.json.JSONUtils;
import com.easycode.message.kafka.consumer.callbackListener.ConsumerCallbackListener;
import com.easycode.message.kafka.template.ConsumerTemplate;
import com.easycode.message.model.UserMessage;

@Component
public class UserMessageConsumer {
	    
    @Resource(name = "searchClient")
    private SearchClient searchClient;
	
    @Resource(name = "kafkaConsumerTemplate")
    private ConsumerTemplate consumerTemplate;
    
    @Value(value = "${message.topic.user.login}")
    private String topic;
    @Value(value = "${message.group.user.login}")
    private String group;
    @Value(value = "${search.index}")
    private String index;
    @Value(value = "${search.type}")
	private String type;
    
    
    @PostConstruct
    private void init(){
    	String [] topics = new String [] {topic};
    	consumerTemplate.startConsumerThread(topics, group, new UserConsumerCallbackListener());
    }
    
    class UserConsumerCallbackListener implements ConsumerCallbackListener{

		@Override
		public void afterReceive(List<Entry<String, String>> messages) {
			// TODO Auto-generated method stub
			if(messages != null && messages.size() > 0){
				Map<Long,byte[]> searchData = new HashMap<Long,byte[]>();
				for(Entry<String,String> message : messages){
					UserMessage userMessage = JSONUtils.fromJSON(message.getValue(), UserMessage.class);					
					searchData.put(userMessage.getUserId(), message.getValue().getBytes());
				}
				searchClient.addSearchRecord(index, type, searchData);
				System.out.println(messages.toString());
			}
		}
    	
    }
}
