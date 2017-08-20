package it.sella.campaign.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.sella.campaign.entities.Campaign;
import it.sella.campaign.service.ICampaignService;

@RestController
@RequestMapping("/Campaign")
public class CampaignController {

	@Autowired
	ICampaignService campaignService;
	
	@RequestMapping("/allCampaign")
	public List<Campaign> getAllCampaign(){
		return campaignService.getAllCampaign();
	}
	
	@RequestMapping("/campaignsByUser/{user}")
	 List<Campaign> getCampaignByName(@PathVariable String user) {
		return campaignService.getCampaignByUser(user);
	 }
	
	@RequestMapping("/SearchStream/{stream}")
	 Collection<String> getStramOnSearch(@PathVariable String stream) {
			return campaignService.getStream(stream);
		 }
}
