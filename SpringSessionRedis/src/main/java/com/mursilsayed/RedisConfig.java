package com.mursilsayed;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.ExpiringSession;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * @See http://stackoverflow.com/questions/21672245/spring-redistemplate-serialise-multiple-model-classes-into-json-need-to-use-mu
 * 
 * @author Mursil
 *
 */
@Configuration
//@EnableRedisHttpSession 
public class RedisConfig {
	
	@Value("${server.session.timeout}")
    private int maxInactiveIntervalInSeconds;
	
	
	@Value("${cacheEvictTimeInSeconds}")
	int cacheEvictTimeInSeconds;
	
	

///////////////Defining Redis Connection Factory & Default Redis Template<String,String>////////////////////////
	/**
	 * @See http://projects.spring.io/spring-data-redis/
	 * @return
	 */
	@Bean
	public JedisConnectionFactory jedisConnFactory()
	{
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setUsePool(true);
		return factory;
				
	}

	@Bean
	@Primary
	public RedisTemplate<String, String> redisTemplate() {
	
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(jedisConnFactory());
		return redisTemplate;
	}
	

	
//////////////////Define the Default Redis Cache Manager ////////////////////////
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
	
	
	

//	@Bean
//    public KeyGenerator customKeyGenerator() {
//	    return new KeyGenerator() {
//	      @Override
//	      public Object generate(Object o, Method method, Object... objects) {
//	        StringBuilder sb = new StringBuilder();
//	        sb.append(o.getClass().getName());
//	        sb.append(method.getName());
//	        for (Object obj : objects) {
//	          sb.append(obj.toString());
//	        }
//	        return sb.toString();
//	      }
//	    };
//	}
	
	
//
//	
//	///////////////////////SessionManager for SpringSession////////////////////////
    @Primary
    @Bean
    public RedisOperationsSessionRepository sessionRepository(RedisTemplate<String, ExpiringSession> sessionRedisTemplate) {
        RedisOperationsSessionRepository sessionRepository = new RedisOperationsSessionRepository(sessionRedisTemplate);
        sessionRepository.setDefaultMaxInactiveInterval(maxInactiveIntervalInSeconds);
        return sessionRepository;
    }
//    
//
//    
//    
//    
//	///////////////////////Default Redis Cache Manager ////////////////////////
//	@Bean
//	@Primary
//	public RedisTemplate<String, String> redisTemplate() {
//	
//		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//		redisTemplate.setConnectionFactory(connectionFactory);
//		return redisTemplate;
//	}
//	
//	@Bean
//	@Primary
//	public CacheManager cacheManager() {
//	
//		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate());
//		// Number of seconds before expiration. Defaults to unlimited (0)
//		cacheManager.setDefaultExpiration(cacheEvictTimeInSeconds);
//		return cacheManager;
//	}
//	
//	
//	
//	
//	
//	///////////////////////Redis Cache Manager for ApplicationParameters////////////////////////
//	@Bean
//	public RedisTemplate<String, ApplicationParameters> redisTemplateApp() {
//    	
//    	RedisTemplate<String, ApplicationParameters> redisTemplate = new RedisTemplate<String, ApplicationParameters>();
//    	redisTemplate.setConnectionFactory(connectionFactory);
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<ApplicationParameters>(ApplicationParameters.class));
//        
//         return redisTemplate;
//    }
//
//    @Bean
//    public CacheManager cacheManagerAppProperties() {
//    	
//    	RedisCacheManager cacheManager = new RedisCacheManager(redisTemplateApp());
//
//      // Number of seconds before expiration. Defaults to unlimited (0)
//      cacheManager.setDefaultExpiration(cacheEvictTimeInSeconds);
//      return cacheManager;
//    }
//	
//   
//    
//    
//	
//
//	///////////////////////Simple Cache Manager for EventConfiguration////////////////////////
//	/**
//	 * @See http://stackoverflow.com/questions/21512791/spring-service-with-cacheable-methods-gets-initialized-without-cache-when-autowi
//	 * @return
//	 */
//	@Bean
//	public CacheManager cacheManagerSimple() {
//	
//		SimpleCacheManager cacheManager = new SimpleCacheManager();
//		
//		cacheManager.setCaches(Arrays.asList(
//                new ConcurrentMapCache("osbmapping")
//        ));
//		
//		
//		return cacheManager;
//	
//	}
	
}