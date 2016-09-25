package com.mursilsayed;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.mursilsayed.sessionobject.ApplicationParameters;


/**
 * @See http://stackoverflow.com/questions/21672245/spring-redistemplate-serialise-multiple-model-classes-into-json-need-to-use-mu
 * 
 * @author Mursil
 *
 */
@Configuration
public class RedisConfig {

	
	
	@Value("${cacheEvictTimeInSeconds}")
	int cacheEvictTimeInSeconds;
	
//	@Value("${spring.redis.host}")
//	String redisHost;
//	
//	@Value("${spring.redis.port}")
//	int redisPort;
	
	
	@Autowired
	private JedisConnectionFactory defaultConnFactory;//Use the default RedisConnection Factory object that will be created by the Spring-Starter-Redis module

	
///////////////Defining Jedis Connection Facotry/////////////////////

//	@Bean
//	private JedisConnectionFactory customizedJedisConnFactory()
//	{
//		JedisConnectionFactory connFac = new JedisConnectionFactory();
//		connFac.setUsePool(true);
//		connFac.setHostName(redisHost);
//		connFac.setPort(redisPort);
//		
//		System.out.println("redisHost:"+redisHost);
//		System.out.println("redisPort:"+redisPort);
//		
//		return connFac;
//		
//	}

	
	protected JedisConnectionFactory getConnectionFactory()
	{
		return defaultConnFactory;
		//return customizedJedisConnFactory();
		
	}
	
///////////////Defining  Default Connection Redis Template<String,String>////////////////////////

	
	@Bean
	@Primary
	public RedisTemplate<String, String> redisTemplate() {
	
//		 
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(getConnectionFactory());
		return redisTemplate;
	}
	

	
//////////////////Define the Default Redis Cache Manager whic works with Default RedisTemplate ////////////////////////
	/**
	 * @See http://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis:support:cache-abstraction
	 * @return
	 */
	@Bean
	@Primary
	public RedisCacheManager cacheManager() {
	
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate());
		// Number of seconds before expiration. Defaults to unlimited (0)
		cacheManager.setDefaultExpiration(cacheEvictTimeInSeconds);
		return cacheManager;
	}
	
	
	

	
	
//
//	

//	
//	///////////////////////Redis Template & Cache Manager for ApplicationParameters////////////////////////
	@Bean
	public RedisTemplate<String, ApplicationParameters> redisTemplateApp() {
    	
    	RedisTemplate<String, ApplicationParameters> redisTemplate = new RedisTemplate<String, ApplicationParameters>();
    	redisTemplate.setConnectionFactory(getConnectionFactory());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<ApplicationParameters>(ApplicationParameters.class));
        
         return redisTemplate;
    }

    @Bean
    public RedisCacheManager cacheManagerAppProperties() {
    	
    	RedisCacheManager cacheManager = new RedisCacheManager(redisTemplateApp());

      // Number of seconds before expiration. Defaults to unlimited (0)
      cacheManager.setDefaultExpiration(cacheEvictTimeInSeconds);
      return cacheManager;
    }
    
    
	
}