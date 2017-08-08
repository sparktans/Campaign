package it.sella.compain.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.sella.compain.entities.Campaign;
import it.sella.compain.repository.CampainRepository;

public class CampaignService implements ICampaignService{
@Autowired
private CampainRepository repository;

public Campaign saveCampaign(Campaign campaign) {
	repository.save(campaign);
	return campaign;
	
}
}
