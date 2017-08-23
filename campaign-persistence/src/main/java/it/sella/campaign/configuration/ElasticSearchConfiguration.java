package it.sella.campaign.configuration;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.elasticsearch.common.settings.Settings;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import javax.annotation.Resource;

@Configuration
@PropertySource(value = "classpath:elasticsearch.properties")
public class ElasticSearchConfiguration {
    @Value("${elasticsearch.clustername}")
    private String esClusterName;
    
    @Resource
    private Environment environment;
    @Bean
    public Client client() throws  UnknownHostException {
    	Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", esClusterName)
                .build();
      TransportClient client = TransportClient.builder().settings(esSettings).build();
         TransportAddress address = new InetSocketTransportAddress(InetAddress.getByName(environment.getProperty("elasticsearch.host")), Integer.parseInt(environment.getProperty("elasticsearch.port")));
        client.addTransportAddress(address);
        String val = null;
       
        return client;
    }
    
    static boolean isPresent(String val) {
    	 return Optional.ofNullable(Optional.ofNullable(val).orElse("")).filter(x -> x.equalsIgnoreCase("null") || x.trim().length() == 0).isPresent();
    }
    public static void main(String[] args) {
		System.out.println(isPresent(null));
		System.out.println(isPresent("NULL"));
		System.out.println(isPresent("null"));
		System.out.println(isPresent(" "));
		System.out.println(isPresent("a"));
	}

  
}