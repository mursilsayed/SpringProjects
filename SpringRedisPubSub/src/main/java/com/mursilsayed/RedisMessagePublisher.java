package com.mursilsayed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;


@Service
@ManagedResource
public class RedisMessagePublisher  {
	 
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Autowired
    private ChannelTopic topic;
 
    public RedisMessagePublisher() {
    }
 
    public RedisMessagePublisher(
      RedisTemplate<String, String> redisTemplate, ChannelTopic topic) {
      this.redisTemplate = redisTemplate;
      this.topic = topic;
    }
 
    @ManagedOperation
    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}