package it.sella.campaign.entities;

public class UserGroup {

	private Long idGroup;
	private String groupName;
	
	public UserGroup(Long idGroup,String groupName) {
		this.idGroup=idGroup;
		this.groupName = groupName;
	}
	public Long getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(Long idGroup) {
		this.idGroup = idGroup;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
