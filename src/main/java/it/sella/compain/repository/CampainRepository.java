package it.sella.compain.repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import it.sella.compain.entities.Campaign;
public interface CampainRepository extends ElasticsearchRepository<Campaign, String>{

}
