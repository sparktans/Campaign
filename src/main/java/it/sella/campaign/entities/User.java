package it.sella.campaign.entities;

import java.util.List;

public class User {

	private String userCode;
	private String userName;
	private String mailId;
	private List<Integer> groupId;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public List<Integer> getGroupId() {
		return groupId;
	}
	public void setGroupId(List<Integer> groupId) {
		this.groupId = groupId;
	}
	
	
}
