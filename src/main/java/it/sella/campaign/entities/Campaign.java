package it.sella.campaign.entities;

import java.util.List;


import com.google.gson.Gson;

import it.sella.campaign.constants.CampaignStatus;

public class Campaign {
	private Long id;
	private String description;
	private String name;
	private String priority;
	private String startDate;
	private String endDate;
	private String createdUser;
	private String createdDate;
	private CampaignStatus status;
	private List<String> stream;
	private List<String> group;
	
	public Long getId() {
		return id;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}


	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public List<String> getStream() {
		return stream;
	}
	public void setStream(List<String> stream) {
		this.stream = stream;
	}
	public List<String> getGroup() {
		return group;
	}
	public void setGroup(List<String> group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public CampaignStatus getStatus() {
		return status;
	}

	public void setStatus(CampaignStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
	 return new Gson().toJson(this);
	}
	
	
}
