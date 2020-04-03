package dkh.demo.service1.providers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dkh.demo.service1.config.Properties;
import dkh.demo.service1.providers.Service1Provider;
import dkh.demo.service1.providers.data.PersonResponse;

@Component
public class Service1ProviderImpl implements Service1Provider{
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private Properties properties;
	
	@Override
	public PersonResponse getPerson() {
		return restTemplate.getForEntity(properties.getDkhService2Url().concat("/person"), PersonResponse.class)
						   .getBody();
	}

}