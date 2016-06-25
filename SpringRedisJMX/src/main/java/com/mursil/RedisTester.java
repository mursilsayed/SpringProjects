package com.mursil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@Service
@ManagedResource
public class RedisTester {
	@Autowired
	RedisTemplate<String,String> redisTemplate;
	
	
	@ManagedOperation
	public void SaveValueInRedis(String key, String value){
		
		redisTemplate.opsForValue().set(key, value);
		
	}
	
	@ManagedOperation
	public String getValueFromRedis(String key){
		
		return 	redisTemplate.opsForValue().get(key);
		
	}
	
	
	@ManagedOperation
	@Cacheable("mursil2")
	public String getComplexValue(){
		
		System.out.print("Complex Value Generated");
		return 	"Complex Value";
		
	}
	

}
