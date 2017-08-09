package it.sella.compain.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sella.compain.entities.Campaign;
import it.sella.compain.repository.CampaignRepository;

@Component
public class CampaignService implements ICampaignService{
@Autowired
private CampaignRepository repository;

public Campaign saveCampaign(Campaign campaign) {
	repository.save(campaign);
	return campaign;
}

@PostConstruct
public void addAndSearchCampaign() {
	Campaign camp=new Campaign();
	camp.setId("1");
	camp.setName("test");
	saveCampaign(camp);
	Campaign camp1=repository.findByName("test");
}
}
