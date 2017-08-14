package it.sella.compain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "campaign", type = "PrimaryKeyGenerator", shards = 1, replicas = 0)
public class PrimaryKeyGenerator {

	@Id
	private String entityName;
	private Integer sequence;
	
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
}
