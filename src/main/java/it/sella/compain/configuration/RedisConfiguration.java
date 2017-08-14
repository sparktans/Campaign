package it.sella.compain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import it.sella.compain.entities.Campaign;

@Configuration

public class RedisConfiguration {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		System.out.println("<<<<<<<jedisConnectionFactory>>>>>>>>>>>>>>>");
	    JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
	    jedisConFactory.setHostName("localhost");
	    jedisConFactory.setPort(6379);
	    return jedisConFactory;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		System.out.println("<<<<<<<redisTemplate>>>>>>>>>>>>>>>");
	    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    template.setKeySerializer( new StringRedisSerializer() );
	   template.setHashValueSerializer( new Jackson2JsonRedisSerializer< Campaign >( Campaign.class ) );
	  template.setValueSerializer( new Jackson2JsonRedisSerializer< Campaign >( Campaign.class ) );
	    return template;
	}
}
