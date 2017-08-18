package it.sella.campaign.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.sella.campaign.entities.Campaign;
import it.sella.campaign.entities.PrimaryKeyGenerator;
import it.sella.campaign.repository.elastic.ICampaignRepository;
import it.sella.campaign.repository.elastic.IPrimaryKeyRepository;
import it.sella.campaign.repository.redis.IRedisCacheRepository;

@Component
public class CampaignService implements ICampaignService{
@Autowired
private ICampaignRepository campaignRepository;

@Autowired
private IPrimaryKeyRepository primaryKeyRepository;

@Autowired
@Qualifier("campaign")
private IRedisCacheRepository<Campaign> cacheRepository;

public Campaign saveCampaign(Campaign campaign) {
	PrimaryKeyGenerator generator = primaryKeyRepository.getPrimaryKeyGenerator("CampaignEntity");
	if(generator == null) {
		generator = new PrimaryKeyGenerator();
		generator.setEntityName("CampaignEntity");
		generator.setSequence(1);
	} else {
		generator.setSequence(generator.getSequence()+1);
	}
	campaign.setId(generator.getSequence());
	campaignRepository.save(String.valueOf(campaign.getId()),campaign);
	primaryKeyRepository.saveOrUpdate(generator.getEntityName(), generator);
	cacheRepository.putCache(campaign);
	getCampaignByName(campaign.getId());
	return campaign;
}

public Campaign getCampaignByName(Integer key) {
	Campaign campaign =cacheRepository.getCache(key);
	System.out.println("camp search >>>>>>>>"+campaign.getDescription());
	return campaign;
}

@Override
public List<Campaign> getAllCampaign() {
	return campaignRepository.getAllCampaign();
}

@PostConstruct
public void addAndSearchCampaign() {
	Campaign camp=new Campaign();
	camp.setName("testing3");
	camp.setDescription("updateServiceName");
	List<String> listStream = new ArrayList<>();
	listStream.add("Java");
	listStream.add("Java enterprice");
	camp.setStream(listStream);
	saveCampaign(camp);
	System.out.println("Save camp done >>>>>>>>"+camp);
//	Campaign camp1=repository.findByName("test");
	//getCampaignByName(camp.getId());
//	System.out.println("camp search >>>>>>>>"+camp1);
//	try {
//		Campaign camp2=repository.findByName("hellowworld");
//		System.out.println("camp search >>>>>>>>"+camp2);
//	} catch(Exception e) {
//		e.printStackTrace();
	}

@Override
public Campaign modifyCampaign(Campaign campaign) {
	// TODO Auto-generated method stub
	return null;
}


	
}

