package it.sella.campaign.repository.elastic;

import java.util.List;

import it.sella.campaign.entities.Campaign;

public interface ICampaignRepository extends IElasticRepository{
	
	public List<Campaign> getAllCampaign();

}
