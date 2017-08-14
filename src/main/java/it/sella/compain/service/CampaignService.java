package it.sella.compain.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.sella.compain.entities.Campaign;
import it.sella.compain.repository.elastic.CampaignRepository;
import it.sella.compain.repository.redis.IRedisCacheRepository;

@Component
public class CampaignService implements ICampaignService{
@Autowired
private CampaignRepository repository;

@Autowired
@Qualifier("campaign")
private IRedisCacheRepository<Campaign> cacheRepository;

public Campaign saveCampaign(Campaign campaign) {
	repository.save(campaign);
	cacheRepository.putCache(campaign);
	return campaign;
}

public Campaign getCampaignByName(Integer key) {
	Campaign campaign =cacheRepository.getCache(key);
	System.out.println("camp search >>>>>>>>"+campaign.getName());
	return campaign;
}

@PostConstruct
public void addAndSearchCampaign() {
	Campaign camp=new Campaign();
	camp.setId(3);
	camp.setName("testing3");
	saveCampaign(camp);
	System.out.println("Save camp done >>>>>>>>"+camp);
//	Campaign camp1=repository.findByName("test");
	getCampaignByName(camp.getId());
//	System.out.println("camp search >>>>>>>>"+camp1);
//	try {
//		Campaign camp2=repository.findByName("hellowworld");
//		System.out.println("camp search >>>>>>>>"+camp2);
//	} catch(Exception e) {
//		e.printStackTrace();
	}

	
}

