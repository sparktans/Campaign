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
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.Resource;

@Configuration
@PropertySource(value = "classpath:elasticsearch.properties")
public class ElasticSearchConfiguration {
    @Value("${elasticsearch.clustername}")
    private String EsClusterName;
    
    @Resource
    private Environment environment;
    @Bean
    public Client client() throws  UnknownHostException {
    	Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", EsClusterName)
                .build();
      TransportClient client = TransportClient.builder().settings(esSettings).build();
         TransportAddress address = new InetSocketTransportAddress(InetAddress.getByName(environment.getProperty("elasticsearch.host")), Integer.parseInt(environment.getProperty("elasticsearch.port")));
        client.addTransportAddress(address);
        return client;
    }

  
}