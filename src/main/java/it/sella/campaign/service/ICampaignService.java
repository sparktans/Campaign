package it.sella.campaign.service;

import java.util.List;

import it.sella.campaign.entities.Campaign;

public interface ICampaignService {
	Campaign saveCampaign(Campaign campaign);
	
	Campaign modifyCampaign(Campaign campaign);
	
	List<Campaign> getAllCampaign();
}