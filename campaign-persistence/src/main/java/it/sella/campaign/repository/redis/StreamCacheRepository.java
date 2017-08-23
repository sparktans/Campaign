package it.sella.campaign.repository.redis;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Qualifier("stream")
public class StreamCacheRepository extends RedisRepository<Collection<String>>{

	
	@Autowired
	@Qualifier("streamRedisTemplate")
	private RedisTemplate<String,Object> redisTemplate;
	
	@Override
	public void putCache(Collection<String> cachedObject) {
		  putObject("StreamCollection", cachedObject);
	}

	@Override
	public Collection<String> getCache(Serializable key) {
		return getObjectByKey(key);
	}

	@Override
	public String getKey() {
		return "Stream";
	}

	@Override
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

}
