package it.sella.campaign.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.sella.campaign.entities.Campaign;
import it.sella.campaign.entities.PrimaryKeyGenerator;
import it.sella.campaign.repository.elastic.ICampaignRepository;
import it.sella.campaign.repository.elastic.IPrimaryKeyRepository;
import it.sella.campaign.repository.redis.IRedisCacheRepository;

@Component
public class CampaignService implements ICampaignService{
	
	 private final Logger slf4jLogger = LoggerFactory.getLogger(CampaignService.class);
	 
@Autowired
private ICampaignRepository campaignRepository;

@Autowired
private IPrimaryKeyRepository primaryKeyRepository;


@Autowired
@Qualifier("campaign")
private IRedisCacheRepository<Campaign> cacheRepository;

@Transactional
public Campaign saveCampaign(Campaign campaign) {
	PrimaryKeyGenerator generator = primaryKeyRepository.getPrimaryKeyGenerator("CampaignEntity");
	if(generator == null) {
		generator = new PrimaryKeyGenerator();
		generator.setEntityName("CampaignEntity");
		generator.setSequence(1l);
	} else {
		generator.setSequence(generator.getSequence()+1);
	}
	campaign.setId(generator.getSequence());
	campaignRepository.save(String.valueOf(campaign.getId()),campaign);
	primaryKeyRepository.saveOrUpdate(generator.getEntityName(), generator);
	cacheRepository.putCache(campaign);
	return campaign;
}

public Campaign getCampaignByName(Long key) {
	Campaign campaign =cacheRepository.getCache(key);
	slf4jLogger.debug("campaign :",campaign.getStream());
	return campaign;
}


public List<Campaign> getCampaignByUser(String user) {
	return campaignRepository.getCampaignByUser(user);
}

@Override
public List<Campaign> getAllCampaign() {
	return campaignRepository.getAllCampaign();
}


public Collection<String> getStream(String searchStream) {
	Collection<String> repositoryStream = campaignRepository.getStreams();
	Collection<String> returnColl = new HashSet<>();
	Optional.ofNullable(repositoryStream).ifPresent(streamItr -> streamItr.forEach(singeStream -> {if(singeStream.toLowerCase().contains(searchStream.toLowerCase())){returnColl.add(singeStream);};}));
	return returnColl;
}

@PostConstruct
public void addAndSearchCampaign() {
//	System.out.println(getStream("ava"));
	/*Campaign camp=new Campaign();
	camp.setName("testing3");
	camp.setStatus(CampaignStatus.CREATE);
	camp.setDescription("updateServiceName");
	List<String> listStream = new ArrayList<>();
	listStream.add("Java");
	listStream.add("Java enterprice");
	camp.setStream(listStream);
	camp.setCreatedUser("GBS02097");
	saveCampaign(camp);
	Campaign camp2=new Campaign();
	camp2.setName("testing3");
	camp2.setDescription("updateServiceName");
	List<String> listStreams = new ArrayList<>();
	listStreams.add("DSN Java");
	listStreams.add("Java enterprice");
	camp2.setStream(listStreams);
	camp2.setCreatedUser("GBS02097");
	camp2.setStatus(CampaignStatus.CREATE);
	saveCampaign(camp2);
	slf4jLogger.debug("Saved Camp :"+camp2);
	slf4jLogger.debug("getAllCampaign :"+getCampaignByUser("GBS02097"));
	 List<Campaign> allCampaignByUser=	getCampaignByUser("GBS02096");
	 allCampaignByUser.forEach(campaign->slf4jLogger.debug(campaign.toString()));*/
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
public void modifyCampaign(Campaign campaign) {
	 campaignRepository.update(campaign.getId() == null ? "" :String.valueOf(campaign.getId()) , campaign);
}


	
}

