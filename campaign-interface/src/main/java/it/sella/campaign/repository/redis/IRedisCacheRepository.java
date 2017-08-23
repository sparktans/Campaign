package it.sella.campaign.repository.redis;

import java.io.Serializable;

public interface IRedisCacheRepository<T> {
	public void putCache(T cachedObject);
	
	public T getCache(Serializable key);
}
