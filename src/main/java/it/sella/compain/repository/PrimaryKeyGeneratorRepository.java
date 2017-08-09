package it.sella.compain.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import it.sella.compain.entities.PrimaryKeyGenerator;

public interface PrimaryKeyGeneratorRepository extends ElasticsearchRepository<PrimaryKeyGenerator, String>{

}
