package it.sella.compain.repository.redis;


import java.io.Serializable;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.sella.compain.entities.Campaign;

@Component
@Qualifier("campaign")
public class CampaignCacheRepository extends RedisRepository<Campaign> {
	

    public void putCache(Campaign campaign) {
      putObject(campaign.getId(), campaign);
    }
    
    public Campaign getCache(Serializable key) {
    	return getObjectByKey(key);
    }
    
    public String getKey() {
    	return  "Campaign";
    }
}
