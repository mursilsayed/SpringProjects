package com.mursilsayed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class PubSubConfiguration {
	
	@Value("${topic}")
	String topic;
	
	@Autowired
	RedisConnectionFactory connFactory;
	
	@Bean
	MessageListenerAdapter messageListener() { 
	    return new MessageListenerAdapter(new RedisMessageSubscriber());
	}
	
	
	@Bean
	RedisMessageListenerContainer redisContainer() {
	    RedisMessageListenerContainer container 
	      = new RedisMessageListenerContainer(); 
	    container.setConnectionFactory(connFactory); 
	    container.addMessageListener(messageListener(), channelTopic() ); 
	    return container; 
	}
	
	@Bean
	ChannelTopic channelTopic()
	{
		return new ChannelTopic(topic);
	}
}
