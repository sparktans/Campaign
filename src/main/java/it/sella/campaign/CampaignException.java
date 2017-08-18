package it.sella.campaign;

public class CampaignException extends RuntimeException{

	
	public CampaignException(String exception, Throwable e) {
		super(exception,e);
	}
	
	public CampaignException(String exception) {
		super(exception);
	}
}
