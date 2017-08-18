package it.sella.campaign.repository.elastic;

import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import it.sella.campaign.CampaignException;


public abstract class ElasticRepository {
	
	@Autowired
	private Client elasticClient;
	
	public void save(String id,Object object) {
		if(!saveOrUpdateOperation(id,object).isCreated()) {
			throw new CampaignException("Problem in save");
		}
	}
	
	public void update(String id,Object object) {
		if(saveOrUpdateOperation(id,object).isCreated()) {
			throw new CampaignException("Problem in update");
		}
	}
	
	public void saveOrUpdate(String id,Object object) {
		saveOrUpdateOperation(id,object);
	}
	
	
	
	private IndexResponse saveOrUpdateOperation(String id,Object object) {
		try {
			return elasticClient.prepareIndex(getIndex(), getType(),id).setSource(new Gson().toJson(object)).execute().get();
			
		} catch (InterruptedException | ExecutionException e) {
			throw new CampaignException("Problem in elastic",e);
		}
	}
	public abstract String getIndex();
	
	public abstract String getType();
	
	public Client getClient() {
		return elasticClient;
	}

}
