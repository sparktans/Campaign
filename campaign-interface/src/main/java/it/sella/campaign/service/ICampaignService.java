package it.sella.campaign.service;

import java.util.Collection;
import java.util.List;

import it.sella.campaign.entities.Campaign;

public interface ICampaignService {
	Campaign saveCampaign(Campaign campaign);
	
	void modifyCampaign(Campaign campaign);
	
	List<Campaign> getAllCampaigns();
	
	List<Campaign> getAllCampaignsByUser(String user) ;
	
	public Collection<String> getStream(String searchStream) ;
}
