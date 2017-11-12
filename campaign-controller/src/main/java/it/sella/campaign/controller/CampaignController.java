package it.sella.campaign.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import it.sella.campaign.entities.Campaign;
import it.sella.campaign.entities.CampaignVO;
import it.sella.campaign.entities.Stream;
import it.sella.campaign.entities.User;
import it.sella.campaign.entities.UserGroup;
import it.sella.campaign.service.ICampaignService;

@RestController

public class CampaignController {

	@Autowired
	ICampaignService campaignService;
	
	@RequestMapping("/allCampaign")
	public List<Campaign> getAllCampaign(){
		return campaignService.getAllCampaigns();
	}
	
	@RequestMapping("/campaignsByUser/{user}")
	 List<Campaign> getCampaignByName(@PathVariable String user) {
		return campaignService.getAllCampaignsByUser(user);
	 }
	
	@RequestMapping("/SearchStream/{stream}")
	 Collection<String> getStramOnSearch(@PathVariable String stream) {
			return campaignService.getStream(stream);
		 }
	
	@RequestMapping(path="/createCampaign", method= RequestMethod.POST)
	Campaign createCampaign(@RequestBody CampaignVO campaign) {
		Campaign camp = new Campaign();
		camp.setName(campaign.getName());
		camp.setName(campaign.getDescription());
		camp.setStream(new ArrayList<>());
		camp.getStream().add(campaign.getStream());
		camp.setGroup(new ArrayList<>());
		camp.getGroup().add(campaign.getGroup());
		camp.setPriority(campaign.getPriority());
		camp.setStartDate(campaign.getStartDate());
		camp.setEndDate(campaign.getEndDate());
		camp.setStartDate(campaign.getName());
		return campaignService.saveCampaign(camp);
		 }
	
	@RequestMapping("/user")
	User getUser() {
		User user = new User();
		user.setUserName("AdminUser");
			return user ;
		 }
	
	@RequestMapping("/allStream")
	 Collection<Stream> getAllStream() {
		return campaignService.getAllStream();
	}
	
	@RequestMapping("/allGroup")
	 Collection<UserGroup> getAllGroup() {
		return campaignService.getAllGroup();
	}
	
	@RequestMapping(path="/createCampaign/{formdata}", method= RequestMethod.POST)
	Campaign createCampaignOnData(@PathVariable String formdata) {
		Campaign campagin = new Gson().fromJson(formdata, Campaign.class);
			return campaignService.saveCampaign(campagin);
		 }
}
