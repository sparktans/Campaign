package it.sella.campaign.entities;


public class PrimaryKeyGenerator {

	private String entityName;
	private Long sequence;
	
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public Long getSequence() {
		return sequence;
	}
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	
}
