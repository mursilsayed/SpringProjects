package com.mursilsayed;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.session.ExpiringSession;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
/**
 * @See http://stackoverflow.com/questions/21672245/spring-redistemplate-serialise-multiple-model-classes-into-json-need-to-use-mu
 * 
 * @author Mursil
 *
 */
@Configuration
@EnableRedisHttpSession 
public class RedisHttpSessionConfig extends CachingConfigurerSupport{
	
	@Value("${server.session.timeout}")
    private int maxInactiveIntervalInSeconds;
	
	@Autowired
	RedisConnectionFactory connectionFactory;

	@Bean
	  public KeyGenerator customKeyGenerator() {
	    return new KeyGenerator() {
	      @Override
	      public Object generate(Object o, Method method, Object... objects) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(o.getClass().getName());
	        sb.append(method.getName());
	        for (Object obj : objects) {
	          sb.append(obj.toString());
	        }
	        return sb.toString();
	      }
	    };
	}
	
	
    @Primary
    @Bean
    public RedisOperationsSessionRepository sessionRepository(RedisTemplate<String, ExpiringSession> sessionRedisTemplate) {
        RedisOperationsSessionRepository sessionRepository = new RedisOperationsSessionRepository(sessionRedisTemplate);
        sessionRepository.setDefaultMaxInactiveInterval(maxInactiveIntervalInSeconds);
        return sessionRepository;
    }
    
    @Bean
    @Primary
    public RedisTemplate<String, Object> redisTemplate() {
      RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
      redisTemplate.setConnectionFactory(connectionFactory);
      redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
      return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
      RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

      // Number of seconds before expiration. Defaults to unlimited (0)
      cacheManager.setDefaultExpiration(300);
      return cacheManager;
    }
	
}