package it.sella.campaign.repository.elastic;

import it.sella.campaign.entities.PrimaryKeyGenerator;

public interface IPrimaryKeyRepository extends IElasticRepository {

	PrimaryKeyGenerator getPrimaryKeyGenerator(String id);
}
