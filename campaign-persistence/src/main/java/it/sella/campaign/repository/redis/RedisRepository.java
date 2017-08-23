package it.sella.campaign.repository.redis;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;


public abstract class RedisRepository<T> implements IRedisCacheRepository<T> {
	
	
    private HashOperations hashOps;
    
    @PostConstruct
    private void init() {
        hashOps = getRedisTemplate().opsForHash();
    }
    
    protected void putObject(Object key,T campaign) {
        hashOps.put(getKey(), key, campaign);
    }
     
    protected T getObjectByKey(Serializable key) {
    	return (T) hashOps.get(getKey(), key);
    }
	public abstract String getKey();
	
	public abstract RedisTemplate<String,Object> getRedisTemplate();
}
