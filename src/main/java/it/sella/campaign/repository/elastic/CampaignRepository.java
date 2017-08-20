package it.sella.campaign.repository.elastic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import it.sella.campaign.CampaignException;
import it.sella.campaign.entities.Campaign;

@Component
public class CampaignRepository extends ElasticRepository implements ICampaignRepository {

	@Override
	public String getIndex() {
		return "campaign";
	}
	
	@Override
	public void update(String id,Object object) {
		GetResponse getResponse = getClient().prepareGet(getIndex(), getType(),id).execute().actionGet();
		if(!getResponse.isExists()) {
			throw new CampaignException("Updation fails because entity is not exist");
		}
		super.update(id, object);
	}
	

	@Override
	public String getType() {
		return "CampaignEntity";
	}

	@Override
	public List<Campaign> getAllCampaign() {
		List<Campaign> campaignCollection = new ArrayList<>();
		SearchResponse requestBuilder = getClient().prepareSearch(getIndex())
				.setTypes(getType())
				.setQuery(QueryBuilders.matchAllQuery()).setSize(1000).execute().actionGet();
		SearchHits searchHits=requestBuilder.getHits();
		SearchHit[] hits=searchHits.getHits();
		List<SearchHit> listOfHit = hits != null ? Arrays.asList(hits) : new ArrayList<>();
		listOfHit.forEach(hit -> campaignCollection.add(new Gson().fromJson(hit.getSourceAsString(), Campaign.class)) );
		return campaignCollection;
	}

	@Override
	public List<Campaign> getCampaignByUser(String user) {
		List<Campaign> campaignCollection = new ArrayList<>();
		SearchResponse requestBuilder = getClient().prepareSearch(getIndex())
				.setTypes(getType()).setQuery(QueryBuilders.commonTermsQuery("createdUser", user)).setSize(1000).execute().actionGet();
		SearchHits searchHits=requestBuilder.getHits();
		SearchHit[] hits=searchHits.getHits();
		List<SearchHit> listOfHit = hits != null ? Arrays.asList(hits) : new ArrayList<>();
		listOfHit.forEach(hit -> {campaignCollection.add(new Gson().fromJson(hit.getSourceAsString(), Campaign.class));});
		return campaignCollection;
	}
	
	public Collection<String> getStreams() {
		Collection<String> arrayList = new HashSet<>();
		SearchResponse requestBuilder = getClient().prepareSearch(getIndex())
				.setTypes(getType()).setSearchType(SearchType.QUERY_AND_FETCH).setFetchSource(new String[]{"stream"}, null).setSize(1000).execute().actionGet();
		SearchHits searchHits=requestBuilder.getHits();
		SearchHit[] hits=searchHits.getHits();
		List<SearchHit> listOfHit = hits != null ? Arrays.asList(hits) : new ArrayList<>();
		listOfHit.forEach(hit -> {
			arrayList.addAll(new Gson().fromJson(hit.getSourceAsString(),  Campaign.class).getStream());} );
	//	listOfHit.forEach(hit -> System.out.println(hit.getSourceAsString()) );
		return arrayList;
	}



}
