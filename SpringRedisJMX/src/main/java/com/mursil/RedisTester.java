package com.mursil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
	@Cacheable(cacheNames="mursil2",key="#value")
	public String getComplexValue(int value){
		
		System.out.print("Complex Value Generated");
		return 	"Complex Value"+value;
		
	}
	
	@ManagedOperation
	@CacheEvict(cacheNames="mursil2", allEntries=true)
	public void evictCacheValues(){
		
		System.out.print("Evicting All Cache values");
		//return 	"Complex Value"+value;
		
	}
	

}
