package it.sella.campaign.repository.elastic;

import org.elasticsearch.action.get.GetResponse;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import it.sella.campaign.entities.PrimaryKeyGenerator;
@Component
public class PrimaryKeyGeneratorRepository extends ElasticRepository implements IPrimaryKeyRepository{

	@Override
	public String getIndex() {
		return "campaign";
	}

	@Override
	public String getType() {
		return "PrimaryKeyGenerator";
	}

	@Override
	public PrimaryKeyGenerator getPrimaryKeyGenerator(String id) {
		PrimaryKeyGenerator primaryKeyObject = null;
		GetResponse getResponse = getClient().prepareGet(getIndex(), getType(),id).execute().actionGet();
		if(getResponse.isExists()) {
			primaryKeyObject=	new Gson().fromJson(getResponse.getSourceAsString(), PrimaryKeyGenerator.class);
		}
		return primaryKeyObject;
	}
}
