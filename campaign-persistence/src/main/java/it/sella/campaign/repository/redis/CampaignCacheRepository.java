package it.sella.campaign.repository.redis;


import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import it.sella.campaign.entities.Campaign;

@Component
@Qualifier("campaign")
public class CampaignCacheRepository extends RedisRepository<Campaign> {
	

	@Autowired(required=false)
	@Qualifier("campaignRedisTemplate")
	private RedisTemplate<String,Object> redisTemplate;
	
    public void putCache(Campaign campaign) {
      putObject(campaign.getId(), campaign);
    }
    
    public Campaign getCache(Serializable key) {
    	return getObjectByKey(key);
    }
    
    public String getKey() {
    	return  "Campaign";
    }

	@Override
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}
}
