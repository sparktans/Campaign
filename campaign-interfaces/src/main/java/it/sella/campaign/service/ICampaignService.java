package it.sella.campaign.service;

import java.util.Collection;
import java.util.List;

import it.sella.campaign.entities.Campaign;
import it.sella.campaign.entities.Stream;
import it.sella.campaign.entities.UserGroup;

public interface ICampaignService {
	Campaign saveCampaign(Campaign campaign);
	
	void modifyCampaign(Campaign campaign);
	
	List<Campaign> getAllCampaigns();
	
	List<Campaign> getAllCampaignsByUser(String user) ;
	
	public Collection<String> getStream(String searchStream) ;
	
	public Collection<Stream> getAllStream();
	
	public Collection<UserGroup> getAllGroup();
	
	
}
