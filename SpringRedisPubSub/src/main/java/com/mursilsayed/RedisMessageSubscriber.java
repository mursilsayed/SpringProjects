package com.mursilsayed;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisMessageSubscriber implements MessageListener {

	@Override
	public void onMessage(Message message, byte[] pattern) {
		// TODO Auto-generated method stub
		//String messageData = String.message.getBody());
		
		System.out.print(message);
		
	}

}
