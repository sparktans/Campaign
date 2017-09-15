package it.sella.campaign.repository.elastic;

public interface IElasticRepository {

	 void save(String id,Object object) ;
	 
	 void update(String id,Object object) ;
	 
	 void saveOrUpdate(String id,Object object) ;
	 
	 
}
