package it.sella.compain.repository.elastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import it.sella.compain.entities.Campaign;
public interface CampaignRepository extends ElasticsearchRepository<Campaign, Integer>{

	Campaign findByName(String name);
}
