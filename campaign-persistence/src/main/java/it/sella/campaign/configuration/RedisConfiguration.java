package it.sella.campaign.configuration;

import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import it.sella.campaign.entities.Campaign;

@Configuration
public class RedisConfiguration {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
	    jedisConFactory.setHostName("localhost");
	    jedisConFactory.setPort(6379);
	    return jedisConFactory;
	}
	
	@Bean(name="campaignRedisTemplate")
	public RedisTemplate<String, Object> campaignRedisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    template.setKeySerializer( new StringRedisSerializer() );
	    template.setHashValueSerializer( new Jackson2JsonRedisSerializer< Campaign >( Campaign.class ) );
	    template.setValueSerializer( new Jackson2JsonRedisSerializer< Campaign >( Campaign.class ) );
	    return template;
	}
	
	
	@Bean(name="streamRedisTemplate")
	public RedisTemplate<String, Object> streamRedisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    template.setKeySerializer( new StringRedisSerializer() );
	    template.setHashValueSerializer(new Jackson2JsonRedisSerializer<HashSet>(HashSet.class));
	    template.setValueSerializer(new Jackson2JsonRedisSerializer<HashSet>(HashSet.class) );
	    return template;
	}
}
